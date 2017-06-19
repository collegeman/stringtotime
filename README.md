**This project is no longer maintained.** I don't do much Java development anymore, but if you've used this library, reach out and share the story with me: [aaron@withfatpanda.com](mailto:aaron@withfatpanda.com).

# Introduction

Being versed in many languages, from time to time we find ourselves coding in one language and longing for the features of another. One such feature missing from Java but built-into PHP is a reliable way of interpreting human descriptions of time into a machine-readable timestamp.

StringToTime for Java is an implementation of PHP's strtotime function, which accepts English descriptions of time like next Tuesday and produces a Unix timestamp of the resulting date. Our Java implementation is a subclass of java.util.Date, so assuming you give it something it can understand, the resulting object is ready and willing to double as a date with no further interpretation needed.

# Getting Started

First, download the library package from this repository's project downloads.

Next, add the stringtotime library (JAR file) to your Java project.

Finally, give it a test run. To test the library, just create an instance of com.clutch.dates.StringToTime with your test string.

	import com.clutch.dates.*;	

	StringToTime date = new StringToTime("next Tuesday");

	assert(date instanceof java.util.Date, "All StringToTime instances of also Date objects.");

Here are some examples of expressions of time that StringToTime understands

- now
- today
- midnight
- morning
- noon
- afternoon
- evening
- tonight
- tomorrow
- tomorrow morning
- noon tomorrow and tomorrow noon
- tomorrow afternoon
- yesterday
- all the permutations of yesterday and morning, noon, afternoon, and evening
- date and time strings
- incremental and decremental expressions like +1 day or -1 week
- virtually any combination of the above!

# Other Ways to Use StringToTime

By default, all expressions of time are calculated from the current time. So +1 day would return a timestamp equal to the current time plus twenty-four hours. You can alter the reference date by passing a Date or Long value as the second parameter to the constructor.

	StringToDate date1 = new StringToDate("+1 day", 372920400000L); // the day after my birthday

	// of course, you could just pass an instance of StringToDate...
	StringToDate date2 = new StringToDate("+1 day", new StringToTime("October 26, 1981"));
	assert(date1.getTime() == date2.getTime());

	// then again, it would be easiest just to pose a single expression
	StringToDate date3 = new StringToDate("October 26, 1981 +1 day");
	assert(date1.getTime() == date3.getTime());

In addition to interpretation on instantiation, there are three static methods that may be used to obtain different expressions of time. They are

	Calendar cal = StringToTime.cal("next Tuesday");

	Long time = StringToTime.time("next Tuesday");

	Date date = StringToTime.date("next Tuesday"); // essentially the same as new StringToTime("next Tuesday");

If you do create an instance of StringToTime, we've made it easy to format the resulting date value with a SimpleDateFormat expression.

	StringToTime date = new StringToTime("next Tuesday");

	String formatted = date.format("MM/dd/yyyy");

# Frequently Asked Questions

## I give StringToTime <code>{expression}</code>, but it doesn't understand. Why?

StringToTime doesn't understand everything (yet), including some notable exceptions like date/time standard ISO 8601. The thing is, not many people type dates in an ISO 8601 standard format. That being said, if you feel like you can make the case for an expression StringToTime should understand, send it to acollegeman@clutch-inc.com.

## The framework I'm using supports Java property editors. How do I make StringToTime the parser for String date values?

We've included com.clutch.dates.DateEditor for just this purpose; however, our editor depends on the ever-versatile Spring Framework. (You can use it in Grails, too!) If you're not using the Spring Framework in your own project (or Grails, which is built on top of Spring), then you'll have to write your own editor.

## About Clutch

Clutch was founded in January 2000 providing web application development and support for the government sector. Since then, we have grown significantly. Each member of our team brings his or her own experiences and ideas to every project.

What's Different About Clutch?

- We make complex things simple.
- We're easy to get along with.
- We have great respect for each other.
- We'll tell you if we don't know the answer; it's about honesty.
- We're very good at balancing the big picture with the details.
- We're serious about what we do but we don't take ourselves too seriously.
- Learn more at [http://clutch-inc.com](http://clutch-inc.com)