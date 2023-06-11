class SnapshotArray {
    int snapId = 0;
    TreeMap<Integer, Integer>[] arr;

    public SnapshotArray(int length) {
        arr = new TreeMap[length];

        for(int i=0; i<length; i++){
            arr[i] = new TreeMap<Integer, Integer>();
            arr[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        arr[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return arr[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */