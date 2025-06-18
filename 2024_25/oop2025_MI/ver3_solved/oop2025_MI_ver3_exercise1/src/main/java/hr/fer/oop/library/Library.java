package hr.fer.oop.library;

public class Library {
    private String name;
    private Resource[] resources;
    private int resourceCount;

    public Library(String name, int capacity) {
        this.name = name;
        this.resources = new Resource[capacity];
        this.resourceCount = 0;
    }

    public String getName() {
        return name;
    }

    public void addResource(Resource resource) {
        if (resourceCount < resources.length) {
            resources[resourceCount++] = resource;
        }
    }

    public void removeResource(String id) {
        for (int i = 0; i < resourceCount; i++) {
            if (resources[i].getId().equals(id)) {
                resources[i] = resources[--resourceCount];
                resources[resourceCount] = null;
                return;
            }
        }
    }

    public Resource findById(String id) {
        for (int i = 0; i < resourceCount; i++) {
            if (resources[i].getId().equals(id)) {
                return resources[i];
            }
        }
        return null;
    }

    public Book[] findInBookTitle(String text) {
        Book[] matches = new Book[resourceCount];
        int matchCount = 0;

        for (int i = 0; i < resourceCount; i++) {
            if (resources[i] instanceof Book && resources[i].getTitle().toLowerCase().contains(text.toLowerCase())) {
                matches[matchCount++] = (Book) resources[i];
            }
        }

        Book[] result = new Book[matchCount];
        System.arraycopy(matches, 0, result, 0, matchCount);
        return result;
    }

    public Resource[] getAllResources() {
        Resource[] result = new Resource[resourceCount];
        System.arraycopy(resources, 0, result, 0, resourceCount);
        return result;
    }
}
