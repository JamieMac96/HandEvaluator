public class Pair<T> {
    private T first;
    private T second;

    Pair(){
        first = null;
        second = null;
    }

    Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public boolean add(T item){
        if (first != null && second != null) return false;

        if (first == null){
            first = item;
            return true;
        }
        else if(second == null){
            second = item;
            return true;
        }

        return false;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString(){
        return "(" + first + "," + second + ")";
    }
}
