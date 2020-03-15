//Student name: Zachary Flahaut
//Student number: 300056316
//Course code: ITI1121
//Lab section: Z-01

public interface OrderedStructure <T extends Comparable<T>> {

    /**
     * Returns the number of elements currently stored in this OrderedStructure.
     *
     * @return the number of elements of this strucutre.
     */

    public abstract int size();

    /**
     * Adds an element in increasing order according to the class'
     * natural comparison method (i.e. uses the method compareTo).
     *
     * @return true if the element can be successfully added to and
     * false otherwise.

     */

    public abstract boolean add(T obj );

    /**
     * Returns the element at the specified position; the first
     * element has the index 0.
     *
     * @return the element at the specified position.
     * @returns null if pos is out of range (pos < 0 || pos >= size()).
     */

    public abstract Object get( int pos ) ;

    /**
     * Removes the element at the specified position; the first
     * element has the index 0.
     *
     * @returns null if pos is out of range (pos < 0 || pos >= size()).
     */

    public abstract void remove( int pos );

}
