//Student name: Zachary Flahaut
//Student number: 300056316
//Course code: ITI1121
//Lab section: Z-01

public class OrderedList< T extends Comparable< T > > implements OrderedStructure<T>{

  private static class Node<E>{

    private E value;

    private Node<E> previous;
    private Node<E> next;

    private Node(E value, Node<E> previous, Node<E> next){
      this.value = value;
      this.previous = previous;
      this.next = next;
    }
  }

  private Node<T> head;

  public OrderedList() {
      head = new Node(null, null,null);
      head.next = head;
      head.previous = head;
  }

  public int size(){
    Node<T> p = head;
    int count = 0;

    while(p.next != head){
      p = p.next;
      count++;
    }
    return count;

  }

  public boolean add(T obj){
    boolean something = true;

    if ( obj == null ){
      something = false;
      throw new IllegalArgumentException("null");
    }
    if ( head.next == head ) {
      head.next = new Node<T>(obj , head, head.next );
    }
    else {
        Node<T> p = head;
        while ( p.next != head && p.next.value.compareTo( obj ) < 0 ) {
          p = p.next;
        }
      Node<T> q = p.next;
      p.next = new Node<T>( obj , p, q );
      q.previous = p.next;
    }
    return something;
  }

  public T get(int pos){
    if (pos < 0)
        throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    Node<T> p = head.next;

    for ( int i = 0; i<pos; i++ ){
      if ( p.next == head ){
        throw new IndexOutOfBoundsException( Integer.toString( pos ) );
      }
      else{
        p = p.next;
      }
    }
    return p.value;
  }

  public void remove(int pos){
    if ( pos < 0 ){
      throw new IndexOutOfBoundsException( Integer.toString(pos));
    }

    Node<T> p = head.next;
    for ( int i=0; i<pos; i++ ){
      if(p.next == head){
        throw new IndexOutOfBoundsException(Integer.toString(pos));
      }
      else{
          p = p.next;

        Node<T> del = p;

        p = p.previous;

        Node<T> q = del.next;

        p.next = q;

        q.previous = p;

        del.value = null;
        del.next = null;
        del.previous = null;
      }
    }

  }

  public void merge( OrderedList<T> other ) {

    Node<T> p = head.next;
      Node<T> q = other.head.next;
      while(q!=other.head){
        if ( p == head ) {
          p.next = new Node<T>( q.value, p, p.next );
          p = p.next;
          q = q.next;
        }
        else if (q.value.compareTo(p.value) < 0){

          p.previous = new Node<T>( q.value, p.previous, p );
          p.previous.previous.next = p.previous;
          q = q.next;
        }
        else if (p.next==head){

          p.next = new Node<T>( q.value, p,head );
          p = p.next;
          q = q.next;
        }
        else {
          p=p.next;
        }
      }
  }
}
