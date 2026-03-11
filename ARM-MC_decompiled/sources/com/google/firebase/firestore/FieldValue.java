package com.google.firebase.firestore;

import java.util.Arrays;
import java.util.List;

public abstract class FieldValue {
    private static final DeleteFieldValue DELETE_INSTANCE = new DeleteFieldValue();
    private static final ServerTimestampFieldValue SERVER_TIMESTAMP_INSTANCE = new ServerTimestampFieldValue();

    /* access modifiers changed from: package-private */
    public abstract String getMethodName();

    FieldValue() {
    }

    static class DeleteFieldValue extends FieldValue {
        DeleteFieldValue() {
        }

        /* access modifiers changed from: package-private */
        public String getMethodName() {
            return "FieldValue.delete";
        }
    }

    static class ServerTimestampFieldValue extends FieldValue {
        ServerTimestampFieldValue() {
        }

        /* access modifiers changed from: package-private */
        public String getMethodName() {
            return "FieldValue.serverTimestamp";
        }
    }

    static class ArrayUnionFieldValue extends FieldValue {
        private final List<Object> elements;

        ArrayUnionFieldValue(List<Object> list) {
            this.elements = list;
        }

        /* access modifiers changed from: package-private */
        public String getMethodName() {
            return "FieldValue.arrayUnion";
        }

        /* access modifiers changed from: package-private */
        public List<Object> getElements() {
            return this.elements;
        }
    }

    static class ArrayRemoveFieldValue extends FieldValue {
        private final List<Object> elements;

        ArrayRemoveFieldValue(List<Object> list) {
            this.elements = list;
        }

        /* access modifiers changed from: package-private */
        public String getMethodName() {
            return "FieldValue.arrayRemove";
        }

        /* access modifiers changed from: package-private */
        public List<Object> getElements() {
            return this.elements;
        }
    }

    static class NumericIncrementFieldValue extends FieldValue {
        private final Number operand;

        NumericIncrementFieldValue(Number number) {
            this.operand = number;
        }

        /* access modifiers changed from: package-private */
        public String getMethodName() {
            return "FieldValue.increment";
        }

        /* access modifiers changed from: package-private */
        public Number getOperand() {
            return this.operand;
        }
    }

    public static FieldValue delete() {
        return DELETE_INSTANCE;
    }

    public static FieldValue serverTimestamp() {
        return SERVER_TIMESTAMP_INSTANCE;
    }

    public static FieldValue arrayUnion(Object... objArr) {
        return new ArrayUnionFieldValue(Arrays.asList(objArr));
    }

    public static FieldValue arrayRemove(Object... objArr) {
        return new ArrayRemoveFieldValue(Arrays.asList(objArr));
    }

    public static FieldValue increment(long j) {
        return new NumericIncrementFieldValue(Long.valueOf(j));
    }

    public static FieldValue increment(double d) {
        return new NumericIncrementFieldValue(Double.valueOf(d));
    }

    public static VectorValue vector(double[] dArr) {
        return new VectorValue(dArr);
    }
}
