package lld.atlassian;

public class File {
    int id;
    String filename;
    int size;
    File(int id, String filename, int size) {
        this.id = id;
        this.filename = filename;
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        File f = (File) obj;
        return f.filename.equals(filename);
    }
}
