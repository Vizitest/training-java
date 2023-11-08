/*
* DO NOT MODIFY THIS COMMENT
* Generated by vizitest
* Test model: 3e1b0807-db36-4431-ae20-b9c7f0ddc106
*/
package B_B40_WaterStateInstance;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import B_B40_WaterStateInstance.WaterStateInstance;

@SuppressWarnings("unused")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WaterStateInstanceTest {
	
//region Scenarios
	@ParameterizedTest(name = "{1} [{index}] {2}")
	@MethodSource({"DefaultScenarioSource"})
	public void DefaultScenarioTest(DefaultScenarioTestData data, String TestName, String TestDescription) {
		ActualResultStorage.setStorage(); //saves the results of the called Methods
		
		assertion(data, data.S1getWaterState.methodName, data.WaterStateInstance, data.S1getWaterState.expectedResult, data.S1getWaterState.call());
	}
//endregion

//region Data

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	private Stream<Arguments> DefaultScenarioSource() throws Exception {
		return Stream.of(
			Arguments.of(
				new DefaultScenarioTestData(
					/* WaterStateInstance WaterStateInstance = */ new WaterStateInstance(-20D),
					/*  S1getWaterState = */ new S1getWaterStateParameters<>(
							ExpectedReturnValueResult.<DefaultScenarioTestData, java.lang.String>builder()
								.setExpectedReturnValue("solid")
						.build()
					)
				),
				/* testCaseName = */ "Positive1",
				/* testCaseDescription = */ ""
			),
			Arguments.of(
				new DefaultScenarioTestData(
					/* WaterStateInstance WaterStateInstance = */ new WaterStateInstance(20D),
					/*  S1getWaterState = */ new S1getWaterStateParameters<>(
							ExpectedReturnValueResult.<DefaultScenarioTestData, java.lang.String>builder()
								.setExpectedReturnValue("solid")
						.build()
					)
				),
				/* testCaseName = */ "Positive2",
				/* testCaseDescription = */ ""
			),
			Arguments.of(
				new DefaultScenarioTestData(
					/* WaterStateInstance WaterStateInstance = */ new WaterStateInstance(150D),
					/*  S1getWaterState = */ new S1getWaterStateParameters<>(
							ExpectedReturnValueResult.<DefaultScenarioTestData, java.lang.String>builder()
								.setExpectedReturnValue("gas")
						.build()
					)
				),
				/* testCaseName = */ "Positive3",
				/* testCaseDescription = */ ""
			),
			Arguments.of(
				new DefaultScenarioTestData(
					/* WaterStateInstance WaterStateInstance = */ new WaterStateInstance(-300D),
					/*  S1getWaterState = */ new S1getWaterStateParameters<>(
							ExpectedReturnValueResult.<DefaultScenarioTestData, java.lang.String>builder()
								.setExpectedReturnValue("invalid temperature")
						.build()
					)
				),
				/* testCaseName = */ "Negative1",
				/* testCaseDescription = */ "WaterStateInstance: Invalid Values"
			)
		);
	}
//endregion

//region Types

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	public static class DefaultScenarioTestData {
		public final WaterStateInstance WaterStateInstance;
		public final S1getWaterStateParameters<DefaultScenarioTestData> S1getWaterState;

		public DefaultScenarioTestData(WaterStateInstance WaterStateInstance, S1getWaterStateParameters<DefaultScenarioTestData> S1getWaterState) {
			this.WaterStateInstance = WaterStateInstance;
			this.S1getWaterState = S1getWaterState;
		}
	}

	public static class S1getWaterStateParameters<TestData> {
		public final String methodName = "S1getWaterState";
		public final Result<TestData> expectedResult;
		public S1getWaterStateParameters(Result<TestData> expectedResult) {
			this.expectedResult = expectedResult;
		}

		public ExceptionFunction<WaterStateInstance, java.lang.String> call() {
			return i ->
			i.getWaterState();
		}
	}
//endregion

//region Vizitest Utils

//=========================================================================================================================
//Please modify this section only in the Modeleditor not here in the code, because otherwise it will cause merge conflicts!
//=========================================================================================================================
	static class ActualResultStorage {
		private static Map<String, Object> actualResultMap = new HashMap<>();
	
		public static void setStorage() {
			actualResultMap = new HashMap<>();
		}
	
		public static <T> void put(String key, T value) {
			actualResultMap.put(key, value);
		}
	
		@SuppressWarnings("unchecked")
		public static <T> T getOrDefault(String key, T defaultValue) {
			return (T) actualResultMap.getOrDefault(key, defaultValue);
		}
	}
	
	
	public static <I> ExceptionFunction<I, VoidR> asFunc(ExceptionConsumer<I> action) {
		return i -> {
			action.accept(i);
			return null;
		};
	}
	
	public static <TestData, Instance, ReturnType> void assertion(TestData data, String methodName, Instance instance, Result<TestData> expectedResult, ExceptionFunction<Instance, ReturnType> toApply) {
		if (expectedResult == null) {
			ActualResultStorage.put(methodName, Assertions.assertDoesNotThrow(() -> toApply.apply(instance)));
			return;
		}
		ReturnType actualResult = null;
		if (expectedResult instanceof ExpectedExceptionResult) {
			Assertions.assertThrows(((ExpectedExceptionResult<TestData>) expectedResult).getExpectedException(), () -> toApply.apply(instance));
		} else {
			actualResult = Assertions.assertDoesNotThrow(() -> toApply.apply(instance));
			if (expectedResult instanceof ExpectedReturnValueResult &&
					!(((ExpectedReturnValueResult<TestData, ReturnType>) expectedResult).getExpectedReturnValue() instanceof VoidR)) {
				assertEqualsByType(((ExpectedReturnValueResult<TestData, ReturnType>) expectedResult).getExpectedReturnValue(),
						actualResult, ((ExpectedReturnValueResult<TestData, ReturnType>) expectedResult).getDelta());
			} else if (expectedResult instanceof CustomAssertionResult) {
				((CustomAssertionResult<TestData, Instance, ReturnType>) expectedResult).getCustomAssertion().accept(instance, actualResult);
			}
			if (expectedResult.getSideEffects() != null) {
				for (SideEffect<TestData> sideEffect : expectedResult.getSideEffects()) {
					Object sideEffectResult = sideEffect.getActualValueAccessor().apply(data);
					assertEqualsByType(sideEffect.getExpectedValue(), sideEffectResult, sideEffect.getDelta());
				}
			}
		}
		ActualResultStorage.put(methodName, actualResult);
	}
	
	private static void assertEqualsByType(Object actualResult, Object expectedResult, double delta) {
		if (actualResult.getClass().isArray() && expectedResult.getClass().isArray()) {
			if (actualResult instanceof Object[] && expectedResult instanceof Object[]) {
				Assertions.assertArrayEquals((Object[]) actualResult, (Object[]) expectedResult);
			} else if (actualResult instanceof byte[] && expectedResult instanceof byte[]) {
				Assertions.assertArrayEquals((byte[]) actualResult, (byte[]) expectedResult);
			} else if (actualResult instanceof short[] && expectedResult instanceof short[]) {
				Assertions.assertArrayEquals((short[]) actualResult, (short[]) expectedResult);
			} else if (actualResult instanceof int[] && expectedResult instanceof int[]) {
				Assertions.assertArrayEquals((int[]) actualResult, (int[]) expectedResult);
			} else if (actualResult instanceof long[] && expectedResult instanceof long[]) {
				Assertions.assertArrayEquals((long[]) actualResult, (long[]) expectedResult);
			} else if (actualResult instanceof float[] && expectedResult instanceof float[]) {
				Assertions.assertArrayEquals((float[]) actualResult, (float[]) expectedResult, (float) delta);
			} else if (actualResult instanceof double[] && expectedResult instanceof double[]) {
				Assertions.assertArrayEquals((double[]) actualResult, (double[]) expectedResult, delta);
			} else if (actualResult instanceof char[] && expectedResult instanceof char[]) {
				Assertions.assertArrayEquals((char[]) actualResult, (char[]) expectedResult);
			} else if (actualResult instanceof boolean[] && expectedResult instanceof boolean[]) {
				Assertions.assertArrayEquals((boolean[]) actualResult, (boolean[]) expectedResult);
			} else {
				Assertions.fail("Unsupported array type");
			}
		} else if (actualResult instanceof Collection && expectedResult instanceof Collection) {
			Assertions.assertIterableEquals((Collection<?>) actualResult, (Collection<?>) expectedResult);
		} else if (Double.isNaN(delta)) {
			Assertions.assertEquals(actualResult, expectedResult);
		} else {
			assert actualResult instanceof Double;
			Assertions.assertEquals((Double) actualResult, (Double) expectedResult, delta);
		}
	}
	
	static class CustomAssertionResult<TestData, TInstance, TReturn> extends Result<TestData> {
		private final BiConsumer<TInstance, TReturn> customAssertion;
	
		protected CustomAssertionResult(CustomAssertionResultBuilder<TestData, TInstance, TReturn, ?, ?> b) {
			super(b);
			this.customAssertion = b.customAssertion;
		}
	
		public static <TestData, TInstance, TReturn> CustomAssertionResultBuilder<TestData, TInstance, TReturn, ?, ?> builder() {
			return new CustomAssertionResultBuilderImpl<TestData, TInstance, TReturn>();
		}
	
		public BiConsumer<TInstance, TReturn> getCustomAssertion() {
			return this.customAssertion;
		}
	
		public String toString() {
			return "CustomAssertionResult(customAssertion=" + this.getCustomAssertion() + ")";
		}
	
		public boolean equals(final Object o) {
			if (o == this) return true;
			if (!(o instanceof CustomAssertionResult)) return false;
			final CustomAssertionResult<?, ?, ?> other = (CustomAssertionResult<?, ?, ?>) o;
			if (!other.canEqual((Object) this)) return false;
			if (!super.equals(o)) return false;
			final Object this$customAssertion = this.getCustomAssertion();
			final Object other$customAssertion = other.getCustomAssertion();
			if (this$customAssertion == null ? other$customAssertion != null : !this$customAssertion.equals(other$customAssertion))
				return false;
			return true;
		}
	
		protected boolean canEqual(final Object other) {
			return other instanceof CustomAssertionResult;
		}
	
		public int hashCode() {
			final int PRIME = 59;
			int result = super.hashCode();
			final Object $customAssertion = this.getCustomAssertion();
			result = result * PRIME + ($customAssertion == null ? 43 : $customAssertion.hashCode());
			return result;
		}
	
		public static abstract class CustomAssertionResultBuilder<TestData, TInstance, TReturn, C extends CustomAssertionResult<TestData, TInstance, TReturn>, B extends CustomAssertionResultBuilder<TestData, TInstance, TReturn, C, B>> extends ResultBuilder<TestData, C, B> {
			private BiConsumer<TInstance, TReturn> customAssertion;
	
			public B setCustomAssertion(BiConsumer<TInstance, TReturn> customAssertion) {
				this.customAssertion = customAssertion;
				return self();
			}
	
			protected abstract B self();
	
			public abstract C build();
	
			public String toString() {
				return "CustomAssertionResult.CustomAssertionResultBuilder(super=" + super.toString() + ", customAssertion=" + this.customAssertion + ")";
			}
		}
	
		private static final class CustomAssertionResultBuilderImpl<TestData, TInstance, TReturn> extends CustomAssertionResultBuilder<TestData, TInstance, TReturn, CustomAssertionResult<TestData, TInstance, TReturn>, CustomAssertionResultBuilderImpl<TestData, TInstance, TReturn>> {
			private CustomAssertionResultBuilderImpl() {
			}
	
			protected CustomAssertionResultBuilderImpl<TestData, TInstance, TReturn> self() {
				return this;
			}
	
			public CustomAssertionResult<TestData, TInstance, TReturn> build() {
				return new CustomAssertionResult<TestData, TInstance, TReturn>(this);
			}
		}
	}
	
	@FunctionalInterface
	interface ExceptionConsumer<I> {
		void accept(I i) throws Exception;
	}
	
	@FunctionalInterface
	interface ExceptionFunction<I, R> {
		R apply(I i) throws Exception;
	}
	
	static class ExpectedExceptionResult<TestData> extends Result<TestData> {
		private final Class<? extends Throwable> expectedException;
	
		protected ExpectedExceptionResult(ExpectedExceptionResultBuilder<TestData, ?, ?> b) {
			super(b);
			this.expectedException = b.expectedException;
		}
	
		public static <TestData> ExpectedExceptionResultBuilder<TestData, ?, ?> builder() {
			return new ExpectedExceptionResultBuilderImpl<TestData>();
		}
	
		public Class<? extends Throwable> getExpectedException() {
			return this.expectedException;
		}
	
		public String toString() {
			return "ExpectedExceptionResult(expectedException=" + this.getExpectedException() + ")";
		}
	
		public boolean equals(final Object o) {
			if (o == this) return true;
			if (!(o instanceof ExpectedExceptionResult)) return false;
			final ExpectedExceptionResult<?> other = (ExpectedExceptionResult<?>) o;
			if (!other.canEqual((Object) this)) return false;
			if (!super.equals(o)) return false;
			final Object this$expectedException = this.getExpectedException();
			final Object other$expectedException = other.getExpectedException();
			if (this$expectedException == null ? other$expectedException != null : !this$expectedException.equals(other$expectedException))
				return false;
			return true;
		}
	
		protected boolean canEqual(final Object other) {
			return other instanceof ExpectedExceptionResult;
		}
	
		public int hashCode() {
			final int PRIME = 59;
			int result = super.hashCode();
			final Object $expectedException = this.getExpectedException();
			result = result * PRIME + ($expectedException == null ? 43 : $expectedException.hashCode());
			return result;
		}
	
		public static abstract class ExpectedExceptionResultBuilder<TestData, C extends ExpectedExceptionResult<TestData>, B extends ExpectedExceptionResultBuilder<TestData, C, B>> extends ResultBuilder<TestData, C, B> {
			private Class<? extends Throwable> expectedException;
	
			public B setExpectedException(Class<? extends Throwable> expectedException) {
				this.expectedException = expectedException;
				return self();
			}
	
			protected abstract B self();
	
			public abstract C build();
	
			public String toString() {
				return "ExpectedExceptionResult.ExpectedExceptionResultBuilder(super=" + super.toString() + ", expectedException=" + this.expectedException + ")";
			}
		}
	
		private static final class ExpectedExceptionResultBuilderImpl<TestData> extends ExpectedExceptionResultBuilder<TestData, ExpectedExceptionResult<TestData>, ExpectedExceptionResultBuilderImpl<TestData>> {
			private ExpectedExceptionResultBuilderImpl() {
			}
	
			protected ExpectedExceptionResultBuilderImpl<TestData> self() {
				return this;
			}
	
			public ExpectedExceptionResult<TestData> build() {
				return new ExpectedExceptionResult<TestData>(this);
			}
		}
	}
	
	static class ExpectedReturnValueResult<TestData, TReturn> extends Result<TestData> {
		private final TReturn expectedReturnValue;
		private double delta = Double.NaN;
	
		protected ExpectedReturnValueResult(ExpectedReturnValueResultBuilder<TestData, TReturn, ?, ?> b) {
			super(b);
			this.expectedReturnValue = b.expectedReturnValue;
			if (b.delta$set) {
			    this.delta = b.delta$value;
			}
		}
	
		public static <TestData, TReturn> ExpectedReturnValueResultBuilder<TestData, TReturn, ?, ?> builder() {
			return new ExpectedReturnValueResultBuilderImpl<TestData, TReturn>();
		}
	
		public TReturn getExpectedReturnValue() {
			return this.expectedReturnValue;
		}
	
		public double getDelta() {
			return this.delta;
		}
	
		public void setDelta(double delta) {
			this.delta = delta;
		}
	
		public String toString() {
			return "ExpectedReturnValueResult(expectedReturnValue=" + this.getExpectedReturnValue() + ", delta=" + this.getDelta() + ")";
		}
	
		public boolean equals(final Object o) {
			if (o == this) return true;
			if (!(o instanceof ExpectedReturnValueResult)) return false;
			final ExpectedReturnValueResult<?, ?> other = (ExpectedReturnValueResult<?, ?>) o;
			if (!other.canEqual((Object) this)) return false;
			if (!super.equals(o)) return false;
			final Object this$expectedReturnValue = this.getExpectedReturnValue();
			final Object other$expectedReturnValue = other.getExpectedReturnValue();
			if (this$expectedReturnValue == null ? other$expectedReturnValue != null : !this$expectedReturnValue.equals(other$expectedReturnValue))
				return false;
			if (Double.compare(this.getDelta(), other.getDelta()) != 0) return false;
			return true;
		}
	
		protected boolean canEqual(final Object other) {
			return other instanceof ExpectedReturnValueResult;
		}
	
		public int hashCode() {
			final int PRIME = 59;
			int result = super.hashCode();
			final Object $expectedReturnValue = this.getExpectedReturnValue();
			result = result * PRIME + ($expectedReturnValue == null ? 43 : $expectedReturnValue.hashCode());
			final long $delta = Double.doubleToLongBits(this.getDelta());
			result = result * PRIME + (int) ($delta >>> 32 ^ $delta);
			return result;
		}
	
		public static abstract class ExpectedReturnValueResultBuilder<TestData, TReturn, C extends ExpectedReturnValueResult<TestData, TReturn>, B extends ExpectedReturnValueResultBuilder<TestData, TReturn, C, B>> extends ResultBuilder<TestData, C, B> {
			private TReturn expectedReturnValue;
			private double delta$value;
			private boolean delta$set;
	
			public B setExpectedReturnValue(TReturn expectedReturnValue) {
				this.expectedReturnValue = expectedReturnValue;
				return self();
			}
	
			public B setDelta(double delta) {
				this.delta$value = delta;
				this.delta$set = true;
				return self();
			}
	
			protected abstract B self();
	
			public abstract C build();
	
			public String toString() {
				return "ExpectedReturnValueResult.ExpectedReturnValueResultBuilder(super=" + super.toString() + ", expectedReturnValue=" + this.expectedReturnValue + ", delta$value=" + this.delta$value + ")";
			}
		}
	
		private static final class ExpectedReturnValueResultBuilderImpl<TestData, TReturn> extends ExpectedReturnValueResultBuilder<TestData, TReturn, ExpectedReturnValueResult<TestData, TReturn>, ExpectedReturnValueResultBuilderImpl<TestData, TReturn>> {
			private ExpectedReturnValueResultBuilderImpl() {
			}
	
			protected ExpectedReturnValueResultBuilderImpl<TestData, TReturn> self() {
				return this;
			}
	
			public ExpectedReturnValueResult<TestData, TReturn> build() {
				return new ExpectedReturnValueResult<TestData, TReturn>(this);
			}
		}
	}
	
	static class ObjectWrapper<T> {
		private final T object;
		private final String referencingMethodName;
	
		public ObjectWrapper(T object, String referencingMethodName) {
			this.object = object;
			this.referencingMethodName = referencingMethodName;
		}
	
		public T get() {
			return ActualResultStorage.getOrDefault(referencingMethodName, object);
		}
	
		public T getObject() {
			return this.object;
		}
	
		public String getReferencingMethodName() {
			return this.referencingMethodName;
		}
	
		public boolean equals(final Object o) {
			if (o == this) return true;
			if (!(o instanceof ObjectWrapper)) return false;
			final ObjectWrapper<?> other = (ObjectWrapper<?>) o;
			if (!other.canEqual((Object) this)) return false;
			final Object this$object = this.getObject();
			final Object other$object = other.getObject();
			if (this$object == null ? other$object != null : !this$object.equals(other$object)) return false;
			final Object this$referencingMethodName = this.getReferencingMethodName();
			final Object other$referencingMethodName = other.getReferencingMethodName();
			if (this$referencingMethodName == null ? other$referencingMethodName != null : !this$referencingMethodName.equals(other$referencingMethodName))
				return false;
			return true;
		}
	
		protected boolean canEqual(final Object other) {
			return other instanceof ObjectWrapper;
		}
	
		public int hashCode() {
			final int PRIME = 59;
			int result = 1;
			final Object $object = this.getObject();
			result = result * PRIME + ($object == null ? 43 : $object.hashCode());
			final Object $referencingMethodName = this.getReferencingMethodName();
			result = result * PRIME + ($referencingMethodName == null ? 43 : $referencingMethodName.hashCode());
			return result;
		}
	
		public String toString() {
			return "ObjectWrapper(object=" + this.getObject() + ", referencingMethodName=" + this.getReferencingMethodName() + ")";
		}
	}
	
	static abstract class Result<TestData> {
		protected final List<SideEffect<TestData>> sideEffects;
	
		protected Result(ResultBuilder<TestData, ?, ?> b) {
			this.sideEffects = b.sideEffects;
		}
	
		public List<SideEffect<TestData>> getSideEffects() {
			return this.sideEffects;
		}
	
		public boolean equals(final Object o) {
			if (o == this) return true;
			if (!(o instanceof Result)) return false;
			final Result<?> other = (Result<?>) o;
			if (!other.canEqual((Object) this)) return false;
			final Object this$sideEffects = this.getSideEffects();
			final Object other$sideEffects = other.getSideEffects();
			if (this$sideEffects == null ? other$sideEffects != null : !this$sideEffects.equals(other$sideEffects))
				return false;
			return true;
		}
	
		protected boolean canEqual(final Object other) {
			return other instanceof Result;
		}
	
		public int hashCode() {
			final int PRIME = 59;
			int result = 1;
			final Object $sideEffects = this.getSideEffects();
			result = result * PRIME + ($sideEffects == null ? 43 : $sideEffects.hashCode());
			return result;
		}
	
		public String toString() {
			return "Result(sideEffects=" + this.getSideEffects() + ")";
		}
	
		public static abstract class ResultBuilder<TestData, C extends Result<TestData>, B extends ResultBuilder<TestData, C, B>> {
			private List<SideEffect<TestData>> sideEffects;
	
			public B setSideEffects(List<SideEffect<TestData>> sideEffects) {
				this.sideEffects = sideEffects;
				return self();
			}
	
			protected abstract B self();
	
			public abstract C build();
	
			public String toString() {
				return "Result.ResultBuilder(sideEffects=" + this.sideEffects + ")";
			}
		}
	}
	
	static final class SideEffect<TestData> {
	
		private final Object expectedValue;
		private final Function<TestData, Object> actualValueAccessor;
		private double delta = Double.NaN;
	
		SideEffect(Object expectedValue, Function<TestData, Object> actualValueAccessor, double delta) {
			this.expectedValue = expectedValue;
			this.actualValueAccessor = actualValueAccessor;
			this.delta = delta;
		}
	
		private static double $default$delta() {
			return Double.NaN;
		}
	
		public static <TestData> SideEffectBuilder<TestData> builder() {
			return new SideEffectBuilder<TestData>();
		}
	
		public Object getExpectedValue() {
			return this.expectedValue;
		}
	
		public Function<TestData, Object> getActualValueAccessor() {
			return this.actualValueAccessor;
		}
	
		public double getDelta() {
			return this.delta;
		}
	
		public void setDelta(double delta) {
			this.delta = delta;
		}
	
		public boolean equals(final Object o) {
			if (o == this) return true;
			if (!(o instanceof SideEffect)) return false;
			final SideEffect<?> other = (SideEffect<?>) o;
			final Object this$expectedValue = this.getExpectedValue();
			final Object other$expectedValue = other.getExpectedValue();
			if (this$expectedValue == null ? other$expectedValue != null : !this$expectedValue.equals(other$expectedValue))
				return false;
			final Object this$actualValueAccessor = this.getActualValueAccessor();
			final Object other$actualValueAccessor = other.getActualValueAccessor();
			if (this$actualValueAccessor == null ? other$actualValueAccessor != null : !this$actualValueAccessor.equals(other$actualValueAccessor))
				return false;
			if (Double.compare(this.getDelta(), other.getDelta()) != 0) return false;
			return true;
		}
	
		public int hashCode() {
			final int PRIME = 59;
			int result = 1;
			final Object $expectedValue = this.getExpectedValue();
			result = result * PRIME + ($expectedValue == null ? 43 : $expectedValue.hashCode());
			final Object $actualValueAccessor = this.getActualValueAccessor();
			result = result * PRIME + ($actualValueAccessor == null ? 43 : $actualValueAccessor.hashCode());
			final long $delta = Double.doubleToLongBits(this.getDelta());
			result = result * PRIME + (int) ($delta >>> 32 ^ $delta);
			return result;
		}
	
		public String toString() {
			return "SideEffect(expectedValue=" + this.getExpectedValue() + ", actualValueAccessor=" + this.getActualValueAccessor() + ", delta=" + this.getDelta() + ")";
		}
	
		public static class SideEffectBuilder<TestData> {
			private Object expectedValue;
			private Function<TestData, Object> actualValueAccessor;
			private double delta$value;
			private boolean delta$set;
	
			SideEffectBuilder() {
			}
	
			public SideEffectBuilder<TestData> setExpectedValue(Object expectedValue) {
				this.expectedValue = expectedValue;
				return this;
			}
	
			public SideEffectBuilder<TestData> setActualValueAccessor(Function<TestData, Object> actualValueAccessor) {
				this.actualValueAccessor = actualValueAccessor;
				return this;
			}
	
			public SideEffectBuilder<TestData> setDelta(double delta) {
				this.delta$value = delta;
				this.delta$set = true;
				return this;
			}
	
			public SideEffect<TestData> build() {
				double delta$value = this.delta$value;
				if (!this.delta$set) {
					delta$value = SideEffect.$default$delta();
				}
				return new SideEffect<TestData>(this.expectedValue, this.actualValueAccessor, delta$value);
			}
	
			public String toString() {
				return "SideEffect.SideEffectBuilder(expectedValue=" + this.expectedValue + ", actualValueAccessor=" + this.actualValueAccessor + ", delta$value=" + this.delta$value + ")";
			}
		}
	}
	
	static class VoidR {
	
	}
	
	  @SafeVarargs
	static <T> List<T> listOf(final T... args) {
		if (args.length == 0) return Collections.emptyList();
		if (args.length == 1) return Collections.singletonList(args[0]);
		return Arrays.asList(args);
	}
	
	@SafeVarargs
	static <K, V> Map<K, V> mapOfEntries(final Map.Entry<K, V>... entries) {
		final Map<K,V> result;
	
		if (entries.length == 0) {
			result = Collections.emptyMap();
		} else if (entries.length == 1) {
			result = Collections.singletonMap(entries[0].getKey(), entries[0].getValue());
		} else {
			result = new LinkedHashMap<>(entries.length);
			for (Map.Entry<K,V> entry : entries) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
	
		return new HashMap<>(result);
	}
	
	static class VizitestMapEntry<K,V> implements Map.Entry<K,V> {
		private final K key;
		private final V value;
	
		public VizitestMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	
		@Override
		public K getKey() {
			return this.key;
		}
	
		@Override
		public V getValue() {
			return this.value;
		}
	
		@Override
		public V setValue(V value) {
			throw new UnsupportedOperationException();
		}
	}
	
	static <K, V> Map.Entry<K, V> entry(K key, V value) {
		return new VizitestMapEntry<>(key, value);
	}
//endregion
}

/*
WARNING: Modification of this comment will make it impossible to merge user-defined changes

BEGIN_CODEGEN_DATA
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
cnT6+/8BMXLEnd9vAAA=
END_CODEGEN_DATA
*/
