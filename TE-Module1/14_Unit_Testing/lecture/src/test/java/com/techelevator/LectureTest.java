package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
import java.util.List;

public class LectureTest {

    //you gotta call the method! not instantiate right away
    private Lecture lecture;

    @Before
    public void setup(){
        lecture = new Lecture();
    }
    @Test
    public void or35_returns_true_when_passed_multiple_of_three(){
        // arrange
        int three = 3;
        //act
        boolean result = lecture.or35(three);
        //assert
        Assert.assertTrue("when i passed in 3 or35() should return true", result);
    }

    @Test
    public void or35_returns_true_when_passed_multiple_of_five(){
        int five = 5;
        boolean result = lecture.or35(five);
        Assert.assertTrue("when passed in 5 or35() should return true", result);
    }
    @Test
    public void or35_returns_false_when_passed_non_multiple_of_three_or_five(){

        boolean result = lecture.or35(4);
        Assert.assertFalse("when passed in 0 or35() should return false", result);
    }

    @Test
    public void firstTwo_returns_string_if_first_2_chars_of_five_length_return_as_length_2_String(){
        String result = lecture.firstTwo("Hello");
        Assert.assertEquals("He", result);

    }
=======
public class LectureTest {

    private Lecture lecture;

    @Before
    public void setup(){
        lecture = new Lecture();
    }

    @Test
    public void or35_return_true_when_passed_multiple_of_three(){
        //arrange
//        int three = 4;
        //act
        boolean result = lecture.or35(3);
        //assert
        Assert.assertTrue("When I passed in 3 or35() should return true", result);
    }

    @Test
    public void or35_return_true_when_passed_multiple_of_five(){
        //arrange - good to go
        //call the freaking method - act
       boolean result =  lecture.or35(5);
       Assert.assertTrue("When I passed in 5 or35() should return true", result);
    }

    @Test
    public void or35_return_false_when_passed_a_non_multiple_of_three_or_five(){
        boolean result = lecture.or35(4);
        Assert.assertFalse(result);
    }

    @Test
    public void firstTwo_returns_string_when_str_length_equal_2(){
        String result = lecture.firstTwo("ab");
        Assert.assertEquals("ab", result);
    }

    @Test
    public void firstTwo_returns_string_when_str_length_less_than_2(){
        String result = lecture.firstTwo("a");
        Assert.assertEquals("a", result);
    }

    @Test
    public void firstTwo_returns_string_with_first_2_char_when_str_length_greater_than_2(){
        String result = lecture.firstTwo("abcde");
        Assert.assertEquals("ab", result);
    }

    @Test
    public void firstTwo_returns_empty_string_when_passed_empty_string(){
        String result = lecture.firstTwo("");
        Assert.assertEquals("", result);
    }

    @Test
    public void firstTwo_null_issues(){
        Assert.assertNotNull(lecture.firstTwo(null));
    }

>>>>>>> 46a60c9459499b0b3a9b755dcbd14c7dac3b7f06
}
