package com.armmc.app.ui.logs;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/armmc/app/ui/logs/LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "WARN", "ERROR", "DEBUG", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LogEntry.kt */
public enum LogLevel {
    INFO,
    WARN,
    ERROR,
    DEBUG;

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }

    static {
        LogLevel[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
