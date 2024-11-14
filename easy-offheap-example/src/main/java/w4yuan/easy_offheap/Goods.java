package w4yuan.easy_offheap;

import w4yuan.offheap.*;
import w4yuan.*;

public class Goods {

    public static final int TOTAL_BYTES = 28;

    public static final int a_OFFSET = 0;
    private static final long a_DEFAULT = 1;
    private OffHeapString b;
    public static final int c_OFFSET = 8;
    private static final byte c_DEFAULT = 2;
    public static final int d_OFFSET = 9;
    private static final boolean d_DEFAULT = true;
    public static final int e_OFFSET = 10;
    private static final float e_DEFAULT = 0.1F;
    public static final int f_OFFSET = 14;
    private static final double f_DEFAULT = 0.2;
    public static final int g_OFFSET = 22;
    private static final int g_DEFAULT = 1;
    private OffHeapLongArray h;
    private OffHeapByteArray i;
    private OffHeapBooleanArray j;
    private OffHeapFloatArray k;
    private OffHeapDoubleArray l;
    private OffHeapIntArray m;
    private Extend n;
    private double o;
    private int[] p;
    private Extend q;
    public static final int r_OFFSET = 26;
    private static final char r_DEFAULT = 'a';


    public final long address;

    private CustomCleaner cleaner;
    public Goods() {
        address = UnsafeMemoryManager.allocateMemory(TOTAL_BYTES);
        cleaner = ReferenceUtils.create(this, new CleanTask(address, TOTAL_BYTES));
        setA(a_DEFAULT);
        setC(c_DEFAULT);
        setD(d_DEFAULT);
        setE(e_DEFAULT);
        setF(f_DEFAULT);
        setG(g_DEFAULT);
        setR(r_DEFAULT);
    }
    public boolean isADefault(long a){
        return a == a_DEFAULT;
    }

    public void setA (long a) {
        UnsafeMemoryManager.putLong(address + a_OFFSET, a);
    }

    public long getA() {
        return UnsafeMemoryManager.getLong(address + a_OFFSET);
    }

    public void setB (String b){
        this.b = new OffHeapString(b);
    }

    public String getB() {
        if (b == null) {
            return null;
        }
        return b.getObject();
    }

    public OffHeapString getRawB() {
        return this.b;
    }
    public boolean isCDefault(byte c){
        return c == c_DEFAULT;
    }

    public void setC (byte c) {
        UnsafeMemoryManager.putByte(address + c_OFFSET, c);
    }

    public byte getC() {
        return UnsafeMemoryManager.getByte(address + c_OFFSET);
    }
    public boolean isDDefault(boolean d){
        return d == d_DEFAULT;
    }

    public void setD (boolean d) {
        UnsafeMemoryManager.putBoolean(address + d_OFFSET, d);
    }

    public boolean getD() {
        return UnsafeMemoryManager.getBoolean(address + d_OFFSET);
    }
    public boolean isEDefault(float e){
        return e == e_DEFAULT;
    }

    public void setE (float e) {
        UnsafeMemoryManager.putFloat(address + e_OFFSET, e);
    }

    public float getE() {
        return UnsafeMemoryManager.getFloat(address + e_OFFSET);
    }
    public boolean isFDefault(double f){
        return f == f_DEFAULT;
    }

    public void setF (double f) {
        UnsafeMemoryManager.putDouble(address + f_OFFSET, f);
    }

    public double getF() {
        return UnsafeMemoryManager.getDouble(address + f_OFFSET);
    }
    public boolean isGDefault(int g){
        return g == g_DEFAULT;
    }

    public void setG (int g) {
        UnsafeMemoryManager.putInt(address + g_OFFSET, g);
    }

    public int getG() {
        return UnsafeMemoryManager.getInt(address + g_OFFSET);
    }


    public void setH (long[] h){
        this.h = new OffHeapLongArray(h);
    }

    public long[] getH() {
        if (h == null) {
            return null;
        }
        return h.getObject();
    }

    public OffHeapLongArray getRawH() {
        return this.h;
    }


    public void setI (byte[] i){
        this.i = new OffHeapByteArray(i);
    }

    public byte[] getI() {
        if (i == null) {
            return null;
        }
        return i.getObject();
    }

    public OffHeapByteArray getRawI() {
        return this.i;
    }


    public void setJ (boolean[] j){
        this.j = new OffHeapBooleanArray(j);
    }

    public boolean[] getJ() {
        if (j == null) {
            return null;
        }
        return j.getObject();
    }

    public OffHeapBooleanArray getRawJ() {
        return this.j;
    }


    public void setK (float[] k){
        this.k = new OffHeapFloatArray(k);
    }

    public float[] getK() {
        if (k == null) {
            return null;
        }
        return k.getObject();
    }

    public OffHeapFloatArray getRawK() {
        return this.k;
    }


    public void setL (double[] l){
        this.l = new OffHeapDoubleArray(l);
    }

    public double[] getL() {
        if (l == null) {
            return null;
        }
        return l.getObject();
    }

    public OffHeapDoubleArray getRawL() {
        return this.l;
    }


    public void setM (int[] m){
        this.m = new OffHeapIntArray(m);
    }

    public int[] getM() {
        if (m == null) {
            return null;
        }
        return m.getObject();
    }

    public OffHeapIntArray getRawM() {
        return this.m;
    }

     public void setN (Extend n){
        this.n = n;
    }

    public Extend getN() {
        return n;
    }

    public void setO (double o) {
        this.o = o;
    }

    public double getO() {
        return this.o;
    }


    public void setP (int[] p){
        this.p = p;
    }

    public int[] getP() {
        return p;
    }

     public void setQ (Extend q){
        this.q = q;
    }

    public Extend getQ() {
        return q;
    }
    public boolean isRDefault(char r){
        return r == r_DEFAULT;
    }

    public void setR (char r) {
        UnsafeMemoryManager.putChar(address + r_OFFSET, r);
    }

    public char getR() {
        return UnsafeMemoryManager.getChar(address + r_OFFSET);
    }
}
