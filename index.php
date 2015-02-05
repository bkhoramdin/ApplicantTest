<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
       class RedTiki{
        public   static $slaves;
        
        
        function __construct()
        {
           
          $this->slaves=14;
       
        }
        public  static  function futureSlaves()
        {
            return self::$slaves+2;
        
         
        }
        public static function test(){
            var_dump(self::$slaves);
        }

 

           public function lettersInRedTiki()
        {
            $name='Red Tiki';
            $testLetters=  array('R','e','d', 'n');
            
           
                    foreach($testLetters as  $testLetter){
             
                if(strpos($name, $testLetter)!==false){
                    echo "The letter '$testLetter'  exists in '$name' as either. <br/>";
                                 
                }else{
                    echo" The letter '$testLetter' is not exist!!!";
                }
            }
        }
        
        }
        RedTiki::lettersInRedTiki();
        
      
   
        ?>
    </body>
</html>
