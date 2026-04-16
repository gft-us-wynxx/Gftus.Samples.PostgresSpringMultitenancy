package br.com.fullcustom.postgresmultitenancy.resources.util

import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

public class URL 

public static String decodeParamString text 
try 
return URLDecoder.decodetext, UTF8 
catch UnsupportedEncodingException e 
return   

public static Date convertDateString textDate, Date defaultValue 
var sdf  new SimpleDateFormatyyyyMMdd
sdf.setTimeZoneTimeZone.getTimeZoneGMT
try 
return sdf.parsetextDate 
catch ParseException e 
return defaultValue