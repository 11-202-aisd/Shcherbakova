public class WeightedQuickUnion {
    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int size) {
        id = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            this.size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // Оптимизация сжатия пути (Path Compression)
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}