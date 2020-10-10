package com.em.sdk.console;


import com.em.sdk.codegen.Console;

import static com.em.sdk.core.utils.Collection.tail;

/**
 * Class for managing our wallet command line utilities.
 */
public class WalletRunner {
    private static final String USAGE = "wallet create|update|send|fromkey";

    public static void run(String[] args) {
        main(args);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            Console.exitError(USAGE);
        } else {
            switch (args[0]) {
                case "create":
                    WalletCreator.run(new String[] {});
                    break;
                case "update":
                    WalletUpdater.run(tail(args));
                    break;
                case "send":
                    WalletSendFunds.run(tail(args));
                    break;
                case "fromkey":
                    KeyImporter.run(tail(args));
                    break;
                default:
                    Console.exitError(USAGE);
            }
        }
    }
}
