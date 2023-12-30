
# Project Settinsg

IDE : Intellij  
Springboot : 3.2.0  
JDK : 17  
DB : MariaDB  


Thymeleaf, lombok, DevTools, Web  



📜 프로젝트 API 명세서  

# 회원가입, 로그인  

회원 가입 페이지	    	Get	        	/member/new  
회원 가입	        		Post	   	    /member/new  

로그인 페이지     		  Get	       	  /member/login  
로그인	            	  Post	    	  /member/login  

# 장바구니  
  
장바구니 담기     		  Post	       	/cart  
장바구니 페이지	    	Get	        	/cart  
장바구니 상품 수정	    (?)	        	/cartItem/{cartItemId  
장바구니 상품 제거  	  (?))	    	  /cartItem/{cartItemId}  
장바구니 상품 주문	    Post	    	  /cart/orders  
  
# 상품  
  
상품 등록 페이지	    	Get	        	/admin/item/new  
상품 등록	        		Post	   	    /admin/item/new  

상품 조회	        		Get	       	  /admin/item/{itemId}  
                                		/admin/items  
                                		/admin/items/{page}  

상품 수정	        		Post	    	  /admin/item/{itemId}  
  
# 주문  
  
주문하기	            	Post	    	  /order  
주문 내역 페이지	    	Get     		  /orders,  
                                	  /orders/{page}  
  
주문 취소	        		Post	   	 /order/{orderId}/cancel  
  


