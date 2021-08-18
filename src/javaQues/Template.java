package javaQues;

public class Template {
	/*
	 * 3d / 4d model
	 * 
	 * 1) What is it all about and associated keywords, benefits A) Experiential
	 * sharing (Examples) - a) Java b) Selenium WebDriver c) Framework coding // d)
	 * Development code
	 * 
	 * B) STAR Technique (System Design and Development)
	 * 
	 * this vs Super
	 * 
	 * this: a reference variable that refers to the current object of a method or
	 *  constructor  --> uses with dot operator to refer vaiables--> this.variable name;
	 * benefit: to remove the confusion between class attributes and
	 * parameters that have same name -->to refer instance variable of current clas
	 * -->to invoke current class constructor (constructor chaining is achieved)
	 * -->can be passed as argument in
	 * method/constructor -->can be returned to the current class instance
	 *
	 * Java :In StringBuilder - the methods inside sTringBuilder such as
	 * insert,replace,deleteCharAt returns the same StringBuilder with return this
	 * 
	 * Selenium: 
	 *
	 *
	 *Framework: used this keyword while we are mentioning the custom errors,or returning the test case names in test summay reports
	 *In setters we have used this keyword to pass value
	 *
	 *super : a reference variable that refers to the parent class object 
	 *@variable level
	 *@method level
	 *@constructor level
	 *
	 *benefit: to differentiate between base class and derived class features super keyword is used wiht base class
	 *-> super.baseClass variable name
	 *-->to invoke parent class
	 *-->used in case of method overriding
	 *-->to invoke parent class 
	 *			constructor call from bottom to top,execute from top to bottom
	 *Super()-->calls default constructor from derived class
	 *-->added in each class automatically by compiler
	 *
	 *
	 *Super(...) -->for calling super class parameterize constructor from derived class constructor
	 *
	 *both cases Super always exeuctes first in body of derived class otherwise throws compiler error
	 *
	 *Java: when u create  StringBuilder by default super (16) is called to create a memory of capacity 16
	 *compareTo mehtod in stringBuilder uses super to return the int after comparing the String
	 *
	 *Selenium:
	 *
	 *Framework:
	 */

}
