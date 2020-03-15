//Student name: Zachary Flahaut
//Student number: 300056316
//Course code: ITI1121
//Lab section: Z-01

public class OrderedListTest {

    public static void main( String[] args ) {

        OrderedList<Integer> a = new OrderedList<Integer>();

        for ( int i=0; i<10; i=i+2 ) {
            a.add( new Integer( i ) );
        }

        OrderedList<Integer> b = new OrderedList<Integer>();

        for ( int i=1; i<10; i=i+2 ) {
            b.add( new Integer( i ) );
        }

        a.merge( b );

        for ( int i=0; i<10; i++ ) {
            int v = ( (Integer) a.get( i ) ).intValue();
            if (v != i) {
                System.out.println("failed, i = " + i);
            }
        }

        a = new OrderedList<Integer>();

        for ( int i=0; i<5; i++ ) {
            a.add( new Integer( i ) );
        }

        b = new OrderedList<Integer>();

        for ( int i=5; i<10; i++ ) {
            b.add( new Integer( i ) );
        }

        a.merge( b );

        for ( int i=0; i<10; i++ ) {
            int v = ( (Integer) a.get( i ) ).intValue();
            if ( v != i ) {
                System.out.println( "fail, i = " + i );
            }
        }

        System.out.println( "done!" );
    }
}
