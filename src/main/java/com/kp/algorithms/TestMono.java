package com.kp.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.kp.util.Util;

import lombok.Cleanup;
import reactor.core.publisher.Mono;

public class TestMono {

   public static void main(String[] args) throws IOException {

      TestMono testMono = new TestMono();
      testMono.readFile().subscribe(Util.onNext(), Util.onError(), Util.onComplete());
      testMono.writeFile("Hola").subscribe(Util.onNext(), Util.onError(), Util.onComplete());

   }

   public Mono<Void> writeFile( String hola) throws IOException {

      return Mono.fromRunnable(() -> {
         try {
            @Cleanup
            FileOutputStream fileOutputStream = new FileOutputStream("Exit.txt");
            for (int i = 0; i < 10; i++) {
               fileOutputStream.write(Util.getFaker().name().fullName().getBytes());
               fileOutputStream.write("\n".getBytes());
            }
         } catch (IOException e) {
            throw new RuntimeException(e);
         }

      });
   }

   public Mono<String> readFile() throws FileNotFoundException, RuntimeException {
      return Mono.fromSupplier(() -> {
         try {
            @Cleanup
            InputStream fileInputStream = new FileInputStream("file.txt");
            Scanner scanner = new Scanner(fileInputStream).useDelimiter("\n");
            while (scanner.hasNext()) {
               System.out.println(scanner.next());
            }

         } catch (IOException e) {
            throw new RuntimeException(e);
         }

         return "file content";
      });
   }
}
