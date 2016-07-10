Created by Xiaohe Cathy Huang.
ToolName: LogFilter

(1)Function Explanation:
When we do a series of actions on a HeadUnit, the correlated logs will be 
generated on different servers based on load balancer. To have a clear view on the request-response information, we need to do two things. 
1.Search for required information and shield unnecessary lines.
2. Merge required logs, which are allocated to different servers ,into one continuously log in an order of timestamp. 
This tool help obtain the final merged log.

(2)Knowledge Used:
K Sorted Linked List+Min Heap

(3)Documents:
1.LogFilter Dev: Source code.
2.LogTool.jar+ input file+origin file,  then run in command line. 
For example,put LogTool.jar, input, and origin into a file called LogFilter Test, and then run command line below.

(3)Steps to run.

Run command java -jar LogTool.jar<inputfile><profileID><outputfile>
ex:LogFilter Test chuang$ java -jar LogTool.jar origin 206706278 final.txt



