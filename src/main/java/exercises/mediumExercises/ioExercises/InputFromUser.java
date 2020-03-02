package exercises.mediumExercises.ioExercises;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class InputFromUser {

    private static final int BUFFER_SIZE = 4;

    public static void main(String[] args) throws IOException {
        File outputFile = new File("files" + File.separator + "userFile.txt");
        if (!outputFile.exists()) outputFile.createNewFile();
        String userText = getStringFromUser();

        RandomAccessFile outputRandomAccesFile = null;
try {
    outputRandomAccesFile = new RandomAccessFile(outputFile, "rw");
    outputRandomAccesFile.seek(0);
}catch (IOException e){
    e.printStackTrace();
}
        FileChannel outChannel = outputRandomAccesFile.getChannel();
        ByteBuffer outBuffer = ByteBuffer.allocate(BUFFER_SIZE);

        try {
            char[] charToBuffer = userText.toCharArray();
            int bufferIndex = 0;

            for (int i = 0; i < charToBuffer.length; i++) {
                if (bufferIndex < BUFFER_SIZE) {
                    outBuffer.put((byte) charToBuffer[i]);
                    bufferIndex++;
                } else {
                    outBuffer.flip();
                    outChannel.write(outBuffer);
                    outBuffer.clear();
                    bufferIndex = 0;
                    outBuffer.put((byte) charToBuffer[i]);
                    bufferIndex++;
                }
            }
            outBuffer.flip();
            outChannel.write(outBuffer);
            outBuffer.clear();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            outputRandomAccesFile.close();
        }

    }

    private static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        String stringFromUser = "";
        System.out.println("Podaj swój tekst. Słowo 'koniec' kończy zapis");


        String lineOfText = scanner.nextLine();
        while (!lineOfText.equals("koniec")) {
            stringFromUser += lineOfText;
            stringFromUser += System.lineSeparator();
            lineOfText = scanner.nextLine();
        }
        return stringFromUser;
    }


}
