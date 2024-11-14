package w4yuan;

import org.junit.Assert;
import org.junit.Test;
import w4yuan.easy_offheap.Extend;
import w4yuan.easy_offheap.Goods;

public class GoodsTest {

	@Test
	public void testGoods() {
		Goods goods = new Goods();
		goods.setA(1L);
		Assert.assertEquals(1L, goods.getA());
		goods.setB("111");
		Assert.assertEquals("111", goods.getB());
		goods.setC((byte) 1);
		Assert.assertEquals((byte) 1, goods.getC());
		goods.setD(true);
		Assert.assertTrue(goods.getD());
		goods.setF(1.1D);
		Assert.assertEquals(1.1D, goods.getF(), 0.0001D);
		goods.setG(2);
		Assert.assertEquals(2, goods.getG());
		long[] longs = new long[10];
		longs[0] = 9L;
		longs[3] = 10L;
		goods.setH(longs);
		long[] h = goods.getH();
		Assert.assertEquals(9L, h[0]);
		Assert.assertEquals(10L, h[3]);

		Assert.assertEquals(9L, goods.getRawH().get(0));
		Assert.assertEquals(10L, goods.getRawH().get(3));

		byte[] bytes = new byte[10];
		bytes[5] = (byte) 5;
		goods.setI(bytes);
		byte[] i = goods.getI();
		Assert.assertEquals((byte) 5, i[5]);
		Assert.assertEquals((byte) 5, goods.getRawI().get(5));

		boolean[] booleans = new boolean[7];
		booleans[2] = true;
		goods.setJ(booleans);
		boolean[] j = goods.getJ();
		Assert.assertTrue(j[2]);
		Assert.assertFalse(j[1]);

		Assert.assertTrue(goods.getRawJ().get(2));
		Assert.assertFalse(goods.getRawJ().get(1));

		float[] floats = new float[8];
		floats[4] = 0.1F;
		goods.setK(floats);
		float[] k = goods.getK();
		Assert.assertEquals(0.1F, k[4], 0.0001F);
		Assert.assertEquals(0.1F, goods.getRawK().get(4), 0.0001F);

		double[] doubles = new double[4];
		doubles[1] = 0.2D;
		goods.setL(doubles);
		double[] l = goods.getL();
		Assert.assertEquals(0.2D, l[1], 0.0001D);
		Assert.assertEquals(0.2D, goods.getRawL().get(1), 0.0001D);

		int[] ints = new int[199];
		ints[198] = 789;
		goods.setM(ints);
		int[] m = goods.getM();
		Assert.assertEquals(789, m[198]);
		Assert.assertEquals(789, goods.getRawM().get(198));


	}

	@Test
	public void testExtends() {
		Goods goods = new Goods();
		Extend extend = new Extend();
		extend.setA(1999);
		goods.setN(extend);
		Assert.assertEquals(1999, goods.getN().getA());
	}
}
