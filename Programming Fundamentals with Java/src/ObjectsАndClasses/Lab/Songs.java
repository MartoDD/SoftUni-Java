package ObjectsАndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("_");

            Song song = new Song();

            song.setTypeList(input[0]);
            song.setName(input[1]);
            song.setTime(input[2]);

            songs.add(song);
        }

        String in = scanner.nextLine();

        if (in.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }

        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(in)) {
                    System.out.println(song.getName());
                }
            }

        }

    }

    public static class Song {
        String typeList;
        String name;
        String time;


        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
