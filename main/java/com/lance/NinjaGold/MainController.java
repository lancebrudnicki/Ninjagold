package com.lance.NinjaGold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session){
		if(session.getAttribute("userGold") == null && session.getAttribute("activityList") == null) {
			ArrayList<String>activityList = new ArrayList<String>();
			session.setAttribute("userGold", 0);
			session.setAttribute("activityList",activityList);
		}
		return "index.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processGold(
			HttpSession session,
			@RequestParam(value="gold") String goldaction
			) {
		Random rand = new Random();
		
		if(session.getAttribute("userGold") == null && session.getAttribute("activityList") == null) {
			ArrayList<String>activityList = new ArrayList<String>();
			session.setAttribute("userGold", 0);
			session.setAttribute("activityList",activityList);
			
		}
		ArrayList<String>list =  (ArrayList<String>)session.getAttribute("activityList");
		if((int) session.getAttribute("userGold") <= -150){
			return "jail.jsp";
		}
		else {
			Integer userGold = (Integer) session.getAttribute("userGold");
			if(goldaction.equals("farm")) {
				int farm = rand.nextInt(11)+10;
				session.setAttribute("messages", farm);
				session.setAttribute("userGold",userGold+farm );
			}else if(goldaction.equals("cave")){
				int cave = rand.nextInt(6)+5;
				session.setAttribute("messages", cave);
				session.setAttribute("userGold",userGold+cave );
			}else if(goldaction.equals("house")){
				int house = rand.nextInt(3)+3;
				session.setAttribute("messages", house);
				session.setAttribute("userGold",userGold+house );
			}else if(goldaction.equals("casino")){
				int casino = rand.nextInt(101)-50;
				session.setAttribute("messages", casino);
				session.setAttribute("userGold",userGold+casino );
			}else if(goldaction.equals("spa")){
				int spa = (rand.nextInt(16)+5)*-1;
				session.setAttribute("messages", spa);
				session.setAttribute("userGold",userGold+spa );
			}
			
			if((int)session.getAttribute("messages") >= 1 ) {				
				String event = "You gained "+ session.getAttribute("messages");
				System.out.println(event);
				list.add(0,event);
			}else if((int)session.getAttribute("messages") <= 0 ) {
				String event = "You lost "+ session.getAttribute("messages");
				System.out.println(event);
				list.add(0,event);
			}
			System.out.println(list);
			session.setAttribute("activityList", list );
			
		return "redirect:/";
		}
	}
}
