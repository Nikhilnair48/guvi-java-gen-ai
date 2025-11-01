package com.guvi.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*

Filename sorter with policy tiers
 - You’ve a list of file names, for example: [“README.md”, “Main.java”, “notes.txt”, “index.md”, “build.gradle”, “App.java”, “todo.md”]
 - Sort them using a single lambda-based Comparator with this policy:
    - Priority by extension: .md first, then .java, then everything else
    - Within the same extension, shorter names first; eg: App > Main
    - If still tied, reverse alphabetical (desc); "TODO.md" vs "AODO.md"

 */
public class FileNameSorter {
    // helper method
    // extPriority -> int
        // if ext is ".md" -> 0
        // else if ext is ".java" -> 1
        // else -> 2
    public static int extPriority(String name) {
        // n -> 0, i -> 1, k -> 2, h -> 3
        // "nikhil" -> name.substring(0, 3) -> "nik"
        // Input: "README.md" -> name.split(".") -> ["README", "md"]
        String[] nameAndExt = name.split("\\.");
        if(nameAndExt[1].equals("md")) {
            return 0;
        } else if(nameAndExt[1].equals("java")) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        //["README.md", "Main.java", "notes.txt", "index.md", "build.gradle", "App.java", "todo.md"]


        List<String> files = new ArrayList<>(List.of("TODO.md", "AODO.md", "README.md", "Mai.java", "notes.txt",
            "index.md", "build.gradle", "App.java", "todo.md"));
        //files.add("README.md");
        //files.add("Main.java");

        // sorting by ".md" files first
        // sorting by ".java" files second

        Comparator<String> comparator = (a, b) -> {
            System.out.print(a + "\t" + b + "\n");
            // README.md and Main.java
            // a -> 1, b -> 0
            int priorityA = extPriority(a);
            int priorityB = extPriority(b);

//            if(priorityA > priorityB) {
//                return 1;
//            } else if(priorityA < priorityB) {
//                return -1;
//            }

            if(priorityA != priorityB) return priorityA - priorityB;
            // App.java and Main.java
            // a -> 3, b -> 4
            int lengthA = a.length();
            int lengthB = b.length();

            if(lengthA != lengthB) return lengthA - lengthB;

            //"App.java" vs "Cat.java" ->
                // "Cat" > "App"
            // "Cat.java", "App.java"
            //- If still tied, reverse alphabetical; "App.java" vs "Cat.java"
            // "Abc" (a) vs "Bcd" (b)
                // "Bbd".compareTo("Bbd") -> 0
            int comparison = b.compareTo(a);
            return comparison;
        };
        // sorts the elements "in place"
        files.sort(comparator);
        System.out.println(files);
    }
}
