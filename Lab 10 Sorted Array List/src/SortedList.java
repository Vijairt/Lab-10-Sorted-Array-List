import java.util.ArrayList;

public class SortedList {
    private final ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String value) {
        int index = findInsertIndex(value);
        list.add(index, value);
    }

    public int findInsertIndex(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = value.compareTo(list.get(mid));

            if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int binarySearch(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = value.compareTo(list.get(mid));

            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -low - 1; // Not found; return negative insertion point
    }

    public String toString() {
        return String.join(", ", list);
    }

    public ArrayList<String> getList() {
        return list;
    }
}
