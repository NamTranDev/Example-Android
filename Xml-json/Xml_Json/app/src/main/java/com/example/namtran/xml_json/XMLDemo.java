package com.example.namtran.xml_json;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Nam Tran on 7/19/2015.
 */
public class XMLDemo {
    public static List<Employee> parseEmployeewithSAX (Context context, int file) throws XmlPullParserException {
        List<Employee> employees = null;
        Employee employee = null;
        XmlPullParser xmlPullParser = context.getResources().getXml(file);
        int EvenType = xmlPullParser.getEventType();
        try {
        while (EvenType != XmlPullParser.END_DOCUMENT)
        {

                String name = xmlPullParser.getName();
                if (EvenType == XmlPullParser.START_DOCUMENT)

                {
                    employees = new ArrayList<>();

                 //   Log.d("Nam","Start Document");
                }else if (EvenType == XmlPullParser.END_DOCUMENT)
                {
                   // Log.d("Nam","End Document");
                }else if (EvenType == XmlPullParser.START_TAG)
                {




                        //  Log.d("Nam","Start Tag");


                        if (name.equals(Employee.EMPOLYEE)) {
                            employee = new Employee();
                            int count = xmlPullParser.getAttributeCount();
                            for (int i = 0; i < count; i++) {
                                //Log.d("NamTran", "Attribute : " + xmlPullParser.getAttributeName(i) + "/" + xmlPullParser.getAttributeValue(i));
                               employee.setId(Integer.parseInt( ""+xmlPullParser.getAttributeValue(i)));
                               // Log.d("Nam",employee.toString());
                            }
                        } else if (name.equals(Employee.FNAME)) {
                            //Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Fname = "" + xmlPullParser.nextText();
                            employee.setFName(Fname);
                            //  Log.d("TranNam",employee.toString());
                        } else if (name.equals(Employee.LNAME)) {
                            // Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Lname = ""  + xmlPullParser.nextText();
                            employee.setLName(Lname);
                            //  Log.d("TranNam",employee.toString());
                        } else if (name.equals(Employee.MINIT)) {
                            //Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Minit = ""  + xmlPullParser.nextText();
                            employee.setMinit(Minit);
                            //  Log.d("TranNam",employee.toString());
                        } else if (name.equals(Employee.SSN)) {
                            //Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Ssn = ""  + xmlPullParser.nextText();
                            employee.setSsn(Ssn);
                            // Log.d("TranNam",employee.toString());
                        } else if (name.equals(Employee.BDATE)) {
                            // Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Bdate = ""  + xmlPullParser.nextText();
                            employee.setBDate(Bdate);
                            // Log.d("TranNam",employee.toString());
                        } else if (name.equals(Employee.ADDRESS)) {
                            // Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Address = ""  + xmlPullParser.nextText();
                            employee.setAddress(Address);
                            // Log.d("TranNam",employee.toString());
                        } else if (name.equals(Employee.SEX)) {
                            // Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Sex = ""  + xmlPullParser.nextText();
                            employee.setSex(Sex);
                            //  Log.d("TranNam",employee.toString());
                        }
                    else if (name.equals(Employee.SALARY))
                    {
                       // Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText() );
                        String Salary = "" + xmlPullParser.nextText();
                        employee.setSalary(Double.parseDouble(Salary));
                    }
                        else if (name.equals(Employee.SUPERSSN)) {
                            //  Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText());
                            String Superssn = "" + xmlPullParser.getName() + " / " + xmlPullParser.nextText();
                            employee.setSuperSsn(Superssn);
                            //  Log.d("TranNam",employee.toString());
                        }
                    else if (name.equals(Employee.DNO))
                    {
                       // Log.d("TranNam",xmlPullParser.getName() + " / " + xmlPullParser.nextText() );
                        String Dno = "" + xmlPullParser.nextText();
                        employee.setDno(Integer.parseInt(Dno));
                    }




                }else if (EvenType == XmlPullParser.END_TAG)
                {
                  //  Log.d("Nam",xmlPullParser.getName());
                    if (name.equals(Employee.EMPOLYEE) && employee != null )
                    {

                             employees.add(employee);

                        //Log.d("TranNam", String.valueOf(employees));

                    }
                }else if (EvenType == XmlPullParser.TEXT)
                {
                   // Log.d("Nam",xmlPullParser.getText());
                }
                EvenType = xmlPullParser.next();

        }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public static List<Employee> parseEmployeewithDOM (Context context , int file)
    {
        List<Employee> employees = new ArrayList<>();
        try {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                //inputStream = context.getResources().openRawResource(file);
                Document document = documentBuilder.parse(context.getResources().openRawResource(file));
                if (document != null)
                {
                    NodeList nodeList = document.getElementsByTagName(Employee.EMPOLYEE);
                    if (nodeList != null)
                    {
                        for (int i =0;i<nodeList.getLength();i++)
                        {
                            Employee employee = new Employee();
                            Element employeeElement = (Element) nodeList.item(i);
                            employee.setId(Integer.parseInt(employeeElement.getAttribute(Employee.ID)));

                            NodeList children = employeeElement.getChildNodes();
                            if (children != null)
                            {
                                for (int j=0;j< children.getLength();j++)
                                {
                                    Node child = children.item(j);
                                    String text = child.getTextContent();
                                    switch (child.getNodeName())
                                    {
                                        case Employee.FNAME:
                                            employee.setFName(text);
                                            break;
                                        case Employee.LNAME:
                                            employee.setLName(text);
                                            break;
                                        case Employee.BDATE:
                                            employee.setBDate(text);
                                            break;
                                        case Employee.DNO:
                                            employee.setDno(Integer.parseInt(text));
                                            break;
                                        case Employee.SALARY:
                                            employee.setSalary(Double.parseDouble(text));
                                            break;
                                        case Employee.SSN:
                                            employee.setSsn(text);
                                            break;
                                        case Employee.SUPERSSN:
                                            employee.setSuperSsn(text);
                                            break;
                                        case Employee.SEX:
                                            employee.setSex(text);
                                            break;
                                        case Employee.MINIT:
                                            employee.setMinit(text);
                                            break;
                                    }
                                }
                            }
                            employees.add(employee);
                        }
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
