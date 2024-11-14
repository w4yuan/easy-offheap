package w4yuan.easy_offheap;

import w4yuan.offheap.*;
import w4yuan.*;

public class Extend {

    public static final int TOTAL_BYTES = 4;

    public static final int a_OFFSET = 0;
    private OffHeapBooleanArray b;


    public final long address;

    private CustomCleaner cleaner;
    public Extend() {
        address = UnsafeMemoryManager.allocateMemory(TOTAL_BYTES);
        cleaner = ReferenceUtils.create(this, new CleanTask(address, TOTAL_BYTES));
    }

    public void setA (int a) {
        UnsafeMemoryManager.putInt(address + a_OFFSET, a);
    }

    public int getA() {
        return UnsafeMemoryManager.getInt(address + a_OFFSET);
    }


    public void setB (boolean[] b){
        this.b = new OffHeapBooleanArray(b);
    }

    public boolean[] getB() {
        if (b == null) {
            return null;
        }
        return b.getObject();
    }

    public OffHeapBooleanArray getRawB() {
        return this.b;
    }
}
