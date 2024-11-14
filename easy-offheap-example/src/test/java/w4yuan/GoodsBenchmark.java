package w4yuan;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import w4yuan.easy_offheap.Goods;
import w4yuan.offheap.OffHeapIntArray;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3)
@Measurement(iterations = 5, time = 3)
@State(value = Scope.Benchmark)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class GoodsBenchmark {


	static Goods goods;

	static HeapGoods heapGoods;

	static {
		String s = "12345678910";
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i + 1;
		}
		long l = 10000L;
		goods = new Goods();
		goods.setA(l);
		goods.setB(s);
		goods.setM(arr);

		heapGoods = new HeapGoods();
		heapGoods.setA(l);
		heapGoods.setB(s);
		heapGoods.setC(arr);
	}


	private static class HeapGoods {
		private Long a;

		private String b;

		private int[] c;

		public Long getA() {
			return a;
		}

		public void setA(long a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}

		public int[] getC() {
			return c;
		}

		public void setC(int[] c) {
			this.c = c;
		}
	}

	@Benchmark
	public Long testOffHeapPri() {
		return goods.getA();
	}

	@Benchmark
	public Long testHeapPri() {
		return heapGoods.getA();
	}

	@Benchmark
	public String testOffHeapString() {
		return goods.getB();
	}


	@Benchmark
	public String testHeapString() {
		return heapGoods.getB();
	}

	@Benchmark
	public int[] testOffHeapArr() {
		return goods.getM();
	}

	@Benchmark
	public int[] testHeapArr() {
		return heapGoods.getC();
	}

	@Benchmark
	public void testTargetOffheapArr(Blackhole bh) {
		OffHeapIntArray rawM = goods.getRawM();
		for (int i = 0; i < rawM.getLength(); i++) {
			bh.consume(rawM.get(i));
		}
	}

	@Benchmark
	public void testTargetheapArr(Blackhole bh) {
		int[] c = heapGoods.getC();
		for (int i = 0; i < c.length; i++) {
			bh.consume(c[i]);
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(GoodsBenchmark.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}
