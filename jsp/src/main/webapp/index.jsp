<html>
<title>hello</title>
<body>
</body>
<%=
    new java.util.Date()
%>
    <hr>
<%
    int sum = 0;
    for (int i=0;i<10;i++){
        sum+=i;
    }
//    out.print(sum);
    out.print("<h3>Sum = "+sum+"</h3>");
%>

<%!
   static {
       System.out.println("Loading servlet");
   }

   private int glocaVar = 0;

   public void a(){
       System.out.println("Hello world");
   }
%>


</html>
