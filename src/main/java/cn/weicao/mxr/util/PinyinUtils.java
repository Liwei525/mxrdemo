package cn.weicao.mxr.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;  
  
public class PinyinUtils {  
  
    private static final Logger logger = Logger.getLogger("devLog");  
      
    public static Map<String,String> dictionary = new HashMap<String,String>();  
  
    //加载多音字词典  
    static{  
          
    	Scanner scan = null;  
        try {  
            Resource resource = new ClassPathResource("pinyin4j/config/duoyinzi_pinyin.txt") ;
            scan = new Scanner(resource.getInputStream()) ;
            scan.useDelimiter("\n") ;
            String line = null;  
            while(scan.hasNext()) {
                line = scan.next() ;  
                String[] arr = line.split("#");  
                  
                if(StringUtils.isNotEmpty(arr[1])){  
                    String[] sems = arr[1].split(" ");  
                    for (String sem : sems) {  
                          
                        if(StringUtils.isNotEmpty(sem)){  
                            dictionary.put(sem , arr[0]);  
                        }  
                    }  
                }  
            }  
              
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            if(scan!=null){  
            	scan.close();  
            }  
        }  
  
    }  
      
    public static String[] chineseToPinYin(char chineseCharacter) throws BadHanyuPinyinOutputFormatCombination{  
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();  
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);  
          
        if(chineseCharacter>=32 && chineseCharacter<=125){    //ASCII >=33 ASCII<=125的直接返回 ,ASCII码表：http://www.asciitable.com/  
            return new String[]{String.valueOf(chineseCharacter)};  
        }  
          
        return PinyinHelper.toHanyuPinyinStringArray(chineseCharacter, outputFormat);  
    }  
      
    /** 
     * 获取汉字拼音的全拼 
     * @param chineseCharacter 
     * @return 
     * @throws BadHanyuPinyinOutputFormatCombination 
     */  
    public static String chineseToPinYinF(String chineseCharacter) throws BadHanyuPinyinOutputFormatCombination{  
        if(StringUtils.isEmpty(chineseCharacter)){  
            return null;  
        }  
          
        char[] chs = chineseCharacter.toCharArray();  
          
        StringBuilder result = new StringBuilder();  
          
        for(int i=0;i<chs.length;i++){  
            String[] arr = chineseToPinYin(chs[i]);  
            if(arr==null){  
                result.append("");  
            }else if(arr.length==1){  
                result.append(arr[0]);  
            }else if(arr[0].equals(arr[1])){  
                result.append(arr[0]);  
            }else{  
                  
                String prim = chineseCharacter.substring(i, i+1);  
//              System.out.println("prim="+prim+"**i="+i);  
                  
                String lst = null,rst = null;  
                  
                if(i<=chineseCharacter.length()-2){  
                    rst = chineseCharacter.substring(i,i+2);  
                }  
                if(i>=1 && i+1<=chineseCharacter.length()){  
                    lst = chineseCharacter.substring(i-1,i+1);  
                }  
                  
//              System.out.println("lst="+lst+"**rst="+rst);  
                  
                String answer = null;  
                for (String py : arr) {  
                      
                    if(StringUtils.isEmpty(py)){  
                        continue;  
                    }  
                      
                    if((lst!=null && py.equals(dictionary.get(lst))) ||  
                            (rst!=null && py.equals(dictionary.get(rst)))){  
                        answer = py;  
//                      System.out.println("get it,answer="+answer+",i="+i+"**break");  
                        break;  
                    }  
                      
                    if(py.equals(dictionary.get(prim))){  
                        answer = py;  
//                      System.out.println("get it,answer="+answer+",i="+i+"**prim="+prim);  
                    }  
                }  
                if(answer!=null){  
                    result.append(answer);  
                }else{  
                	result.append(arr[0]); 
                    logger.warn("no answer ch="+chs[i]);  
                }  
            }  
        }  
          
        return result.toString().toLowerCase();  
    }  
      
    public static String chineseToPinYinS(String chineseCharacter) {  
        if(StringUtils.isEmpty(chineseCharacter)){  
            return null;  
        }  
          
        char[] chs = chineseCharacter.toCharArray();  
          
        StringBuilder result = new StringBuilder();  
          
        for(int i=0;i<chs.length;i++){  
            String[] arr;
			try {
				arr = chineseToPinYin(chs[i]);
	            if(arr==null){  
	                result.append("");  
	            }else if(arr.length==1){  
	                result.append(arr[0].charAt(0));  
	            }else if(arr[0].equals(arr[1])){  
	                result.append(arr[0].charAt(0));  
	            }else{  
	                  
	                String prim = chineseCharacter.substring(i, i+1);  
	                //System.out.println("prim="+prim+"**i="+i);  
	                  
	                String lst = null,rst = null;  
	                  
	                if(i<=chineseCharacter.length()-2){  
	                    rst = chineseCharacter.substring(i,i+2);  
	                }  
	                if(i>=1 && i+1<=chineseCharacter.length()){  
	                    lst = chineseCharacter.substring(i-1,i+1);  
	                }  
	                  
	                //System.out.println("lst="+lst+"**rst="+rst);  
	                  
	                String answer = null;  
	                for (String py : arr) {  
	                      
	                    if(StringUtils.isEmpty(py)){  
	                        continue;  
	                    }  
	                      
	                    if((lst!=null && py.equals(dictionary.get(lst))) ||  
	                            (rst!=null && py.equals(dictionary.get(rst)))){  
	                        answer = py;  
	                        //System.out.println("get it,answer="+answer+",i="+i+"**break");  
	                        break;  
	                    }  
	                      
	                    if(py.equals(dictionary.get(prim))){  
	                        answer = py;  
	                        //System.out.println("get it,answer="+answer+",i="+i+"**prim="+prim);  
	                    }  
	                }  
	                if(answer!=null){  
	                    result.append(answer.charAt(0));  
	                }else{  
	                	result.append(arr[0].charAt(0)); 
	                    logger.warn("no answer ch="+chs[i]);  
	                }  
	            }  
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}  
        }  
          
        return result.toString().toLowerCase();  
    }  
          
}