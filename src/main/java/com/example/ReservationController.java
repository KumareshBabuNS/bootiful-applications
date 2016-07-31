package com.example;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

	private ReservationRepository reservationRepository;

	@Autowired
	public ReservationController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@RequestMapping(method=RequestMethod.GET, value="/reservations.html")
	public ModelAndView reservationsAsHtml() {
		ModelAndView mv = new ModelAndView("reservations");
		mv.addObject("reservations", reservationRepository.findAll());
		return mv;
	}

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/reservations.json")
	public Collection<Reservation>reservations() {
		return reservationRepository.findAll();
	}

}
