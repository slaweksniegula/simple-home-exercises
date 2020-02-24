package mediumExercises;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Test {

    private static final int BUFFOR_SIZE = 4;

    public static void main(String[] args) throws IOException {

        File userFile = new File("files" + File.separator + "userFile.txt");
        if (!userFile.exists()) userFile.createNewFile();

        String userString = getUserString();
        RandomAccessFile outputRandomAcessFile = new RandomAccessFile(userFile, "rw");
        outputRandomAcessFile.seek(0);

        FileChannel outputChannel = outputRandomAcessFile.getChannel();
        ByteBuffer outputByteBuffer = ByteBuffer.allocate(BUFFOR_SIZE);

        char[] bufferdChar = userString.toCharArray();
        int curentBufferSize = 0;

        for (int i = 0; i < bufferdChar.length; i++) {
            if (curentBufferSize < BUFFOR_SIZE){
                outputByteBuffer.put((byte)bufferdChar[i]);
                curentBufferSize++;
            }else{
                outputByteBuffer.flip();
                outputChannel.write(outputByteBuffer);
                outputByteBuffer.clear();
                curentBufferSize = 0;;
                outputByteBuffer.put((byte)bufferdChar[i]);
                curentBufferSize++;
            }
            outputByteBuffer.flip();
            outputChannel.write(outputByteBuffer);
            outputByteBuffer.clear();
            curentBufferSize = 0;
        }
        outputRandomAcessFile.close();
    }


    private static String getUserString(){

        String userString = "";
        String userLine;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj teksty");
        userLine = scanner.nextLine();
        while (!userLine.equals("*")){
            userString+= userLine;
            userString+= System.lineSeparator();
            userLine = scanner.nextLine();
        }
                return userString;
    }
}