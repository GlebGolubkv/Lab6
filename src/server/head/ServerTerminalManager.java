package server.head;

import java.util.Scanner;


public class ServerTerminalManager {

    private final Scanner scanner;
    private final ServerNetworkManager serverNetworkManager;

    public ServerTerminalManager(Scanner scanner, ServerNetworkManager serverNetworkManager) {
        this.scanner = scanner;
        this.serverNetworkManager = serverNetworkManager;
    }

    public void start() {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            System.out.println("Shutting down...");

        }));

        Thread thread = new Thread(() -> {

            System.out.println("Console active (commands: exit)");

            while (true) {
                String command = scanner.nextLine().toLowerCase().trim();

                switch (command) {

                    case "exit" -> {
                        serverNetworkManager.makeShutdown();
                    }


                }
            }


        });
        thread.setDaemon(true);
        thread.start();

    }

}
