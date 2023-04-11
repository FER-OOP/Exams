package zi.zad04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zi.ScientificPaper;
import zi.zad03.DemoPapers;

public class Main {

	// Model posla:
	static class Job implements Runnable {
		private List<ScientificPaper> papers;

		public Job(List<ScientificPaper> papers) {
			super();
			this.papers = papers;
		}
		
		@Override
		public void run() {
			for(ScientificPaper p : papers) {
				DemoPapers.convert(p);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		List<ScientificPaper> papers = loaderPapers();
		
		List<List<ScientificPaper>> list = divide(papers, 4);

		// Stvori 4 dretve - svaka radi konverziju svojih radova
		Thread[] workers = new Thread[4];
		for(int i = 0; i < 4; i++) {
			workers[i] = new Thread(new Job(list.get(i)));
			workers[i].start();
		}
		
		// Pričekaj da pretvorbe završe
		for(Thread worker : workers) {
			while(true) {
				try {
					worker.join();
					break;
				} catch (InterruptedException e) {
				}
			}
		}
		
		System.out.println("Pretvorbe su gotove.");
	}

	private static List<List<ScientificPaper>> divide(List<ScientificPaper> papers, int sublists) {
		int n = papers.size() / sublists;
		int m = papers.size() % sublists;
		List<List<ScientificPaper>> list = new ArrayList<>();
		int start = 0;
		for(int i = 0; i < sublists; i++) {
			int end = start + n;
			if(m>0) {
				end++; m--;
			}
			list.add(papers.subList(start, end));
			start = end;
		}
		return list;
	}

	private static List<ScientificPaper> loaderPapers() {
		return DemoPapers.create();
	}
}
