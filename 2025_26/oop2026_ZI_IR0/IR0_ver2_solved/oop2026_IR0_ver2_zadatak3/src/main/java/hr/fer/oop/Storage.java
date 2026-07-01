package hr.fer.oop;

import java.util.*;

public class Storage {
    private final Map<String, Box<Vinyl>> boxes = new LinkedHashMap<>();

    public void addBox(String name, Box<Vinyl> box) throws StorageException {
        if (boxes.containsKey(name)) {
            throw new StorageException("Box already exists: " + name);
        }
        boxes.put(name, box);
    }

    public void store(String boxName, Vinyl vinyl) throws StorageException {
    	Box<Vinyl> box = boxes.get(boxName);
        if (box == null) {
            throw new StorageException("Box not found: " + boxName);
        }
        box.add(vinyl);
    }

    public String getMostExpensiveBoxName() {
        String bestName = null;
        double max = -1;
        for (Map.Entry<String, Box<Vinyl>> entry : boxes.entrySet()) {
            double value = entry.getValue().totalValue();
            if (value > max) {
                max = value;
                bestName = entry.getKey();
            }
        }
        return bestName;
    }

    public List<Vinyl> findByArtist(String artist) {
        List<Vinyl> result = new ArrayList<>();
        for (Box<Vinyl> box : boxes.values()) {
            for (Object item : box.getItems()) {
                Vinyl v = (Vinyl) item;
                if (v.getArtist().equals(artist)) {
                    result.add(v);
                }
            }
        }
        return result;
    }

    public List<String> getAllVinylTitlesAlphabetically() {
        List<String> all = new ArrayList<>();
        for (Box<Vinyl> box : boxes.values()) {
            for (Object item : box.getItems()) {
            	Vinyl v = (Vinyl) item;
            	all.add(v.getTitle());
            }
        }

        Collections.sort(all);
        return all;
    }
}