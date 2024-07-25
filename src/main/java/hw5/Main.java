package hw5;

import java.io.File;

//Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
//во вновь созданную папку ./backup
//Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
//и представляют собой, например, состояния ячеек поля для игры в крестикинолики,
//где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {

        String sourceDirPath = "src/main/java/hw4";
        String backupDirPath = "src/main/backup";

        createBackup(sourceDirPath,backupDirPath);

        int[] ticTacToeBoard = {1, 2, 0, 0, 1, 2, 2, 0, 1};
        checkTicTacToeBoard(ticTacToeBoard);
    }

    public static void createBackup(String sourceDirPath, String backupDirPath) {
        File sourceDir = new File(sourceDirPath);
        File backupDir = new File(backupDirPath);

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File[] files = sourceDir.listFiles(((dir, name) -> !new File(dir, name).isDirectory()));

        if (files != null) {
            for (File file : files) {
                Path sourceFilePath = file.toPath();
                Path backupFilePath = backupDir.toPath().resolve(file.getName());

                try {
                    Files.copy(sourceFilePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл" + file.getName() + " скопированы в " + backupDirPath);
                } catch (IOException e) {
                    System.err.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                }
            }
        } else {
            System.err.println("Не удалось получить список файлов из директории " + sourceDirPath);
        }
    }

    public static void checkTicTacToeBoard(int[] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException("Неверный размер игрового поля. Поле должно содержать 9 элементов.");
        }

        for (int state : board) {
            if (state < 0 || state > 3) {
                throw new IllegalArgumentException("Неверное значение состояния ячейки: " + state + ". Допустимые значения: 0, 1, 2, 3.");
            }
        }

        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combination : winningCombinations) {
            if (board[combination[0]] != 0 &&
                    board[combination[0]] == board[combination[1]] &&
                    board[combination[1]] == board[combination[2]]) {
                System.out.println("Победитель: " + (board[combination[0]] == 1 ? "Крестики" : "Нолики"));
                return;
            }
        }

        System.out.println("Победителя нет.");
    }
}

