
/*
 * (rename words)
 * Write a program that renames all occurrences of a word
 * with a new word in all the files under a directory, recursively.
 * Pass the parameters from the command line as follows:
 *
 *  java Exercise18_31 dirName oldWord newWord
 *
 */

// ! Direktori yang dipakai adalah direktori bernama 'dummy'

import java.io.*;
import java.util.Scanner;

public class lat18_31_$$ {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: dirName oldWord newWord");
      return;
    }

    File file = new File(args[0]);
    renameOccurrence(file, args[1], args[2]);
  }

  // * Method rekursif untuk mangganti semua oldWord dengan newWord
  static void renameOccurrence(File file, String oldWord, String newWord) {
    // * Cek apakah 'file' yang masukkan merupakan file atau bukan
    if (file.isFile()) {
      String s = "";
      try (Scanner in = new Scanner(file)) { // ! Error handling saya tidak begitu paham soal ini
        while (in.hasNext()) { // * 1 token, sederhananya, merupakan sederetan char yang tidak dipisah oleh
                               // spasi sama sekali
          s += in.nextLine(); // * "abcdefg" -> 1 token | "abc def g" -> 3 token ("abc", "def", "g")
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      if (s.length() > 0) {
        s = s.replace(oldWord, newWord); // * Ganti oldWord dengan newWord
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file, false))) {
          out.write(s.getBytes()); // * Tuliskan s ke dalam file
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    } else { // * Jika 'file' merupakan directory alih-alih file
      File[] files = file.listFiles(); // * Mendata semua file dalam 'file' dan menaruhnya ke dalam array files[]
      if (files != null) { // * Cek apakah directory-nya kosong
        for (File f : files) { // * Iterasi ke masing-masing file dalam files[] untuk mengganti semua oldWord
                               // dengan newWord
          renameOccurrence(f, oldWord, newWord); // * Recursive call
        }
      }
    }
  }
}