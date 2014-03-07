package chapter7_other;

import java.lang.annotation.Repeatable;

@Repeatable(TestCases.class)
@interface TestCase {
   String params();
   String expected();
}

@interface TestCases {
   TestCase[] value();
}