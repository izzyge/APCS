import  java.util.ArrayList;

public class SongRunner{
    public static void main(String args[]){
        //What do you have to import to use ArrayList?

        //What do you think the ? in ArrayList< ? > represents?
        ArrayList<Song> songList1 = new ArrayList<Song>();

        ArrayList<Song> songList2 = new ArrayList<Song>();

        //What do you think the method add() does?
        songList1.add(new Song("John", "Happy"));
        songList1.add(new Song("Jose", "Hello"));

        songList2.add(new Song("Ella", "Say My Name"));
        songList2.add(new Song("Margo", "Dose"));
        songList2.add(new Song("Rachel", "Solo"));

        //What do you think the method get() does?
        //What method gets called by default when you don't use getName() ?
        System.out.println();
        System.out.println( songList1.get(0).getName() );
        System.out.println( songList1.get(1).getName() );
        System.out.println( songList1.get(0) );
        System.out.println( songList1.get(1) );

        System.out.println( songList2.get(0) );
        System.out.println( songList2.get(2) );

        //What do you think the method set() does?
        System.out.println();
        songList1.set(1, new Song("Jen", "Happy Days") );
        System.out.println( songList1.get(1) );

    }
}
