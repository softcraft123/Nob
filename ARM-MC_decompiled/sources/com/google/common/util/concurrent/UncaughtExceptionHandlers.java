package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
public final class UncaughtExceptionHandlers {
    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }

    static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final Logger logger = Logger.getLogger(Exiter.class.getName());
        private final Runtime runtime;

        Exiter(Runtime runtime2) {
            this.runtime = runtime2;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[]{thread}), th);
            } catch (Error | RuntimeException e) {
                System.err.println(th.getMessage());
                System.err.println(e.getMessage());
            } finally {
                this.runtime.exit(1);
            }
        }
    }
}
