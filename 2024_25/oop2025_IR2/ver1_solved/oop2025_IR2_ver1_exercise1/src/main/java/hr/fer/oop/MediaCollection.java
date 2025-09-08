package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;

class MediaCollection {
    private List<Content<?>> items = new ArrayList<>();

    public void addItem(Content<?> item) {
        items.add(item);
    }

    public List<Content<?>> getAllItems() {
        return new ArrayList<>(items);
    }

    public <T extends Content<?>> List<T> getItemsOfTheSameTypeAsObject(T type) {
        List<T> result = new ArrayList<>();
        for (Content<?> item : items) {
	        if (type instanceof Book && item instanceof Book) {
				result.add((T)item);
            } else if (type instanceof Magazine && item instanceof Magazine) {
            	result.add((T)item);
			} else if (item instanceof DVD && type instanceof DVD) {
				result.add((T)item);
			} 
        	// Alternatively, it is possible to use isInstance to check if the item is of the specified type
            /*if (type.isInstance(item)) {
                result.add(type.cast(item));
            }*/
        }
        return result;
    }

    public void printAllDescriptions() {
        for (Content<?> item : items) {
            System.out.println(item.getDescription());
        }
    }
}
