package com.nasa.NasaDemo;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NasaController {
	@GetMapping("/nasa/api/apod")
    public String apodForm(Model model)
    {
		model.addAttribute("apodinput", new SpecificDate());
		return "apodinput";
    }
	
	@PostMapping("/nasa/api/apod")
    public String apodSpecificDate(@ModelAttribute SpecificDate specificDate, Model model)
    {
		
		String url = "https://api.nasa.gov/planetary/apod?date="+specificDate.getDate()+"&api_key=GbmHwXYBm5sr50aITrpScOtQW0kVbmF1UmUPXlRv";
		RestTemplate rtemplate = new RestTemplate();
		String responseJsonString = rtemplate.getForObject(url, String.class);
		apodImage apodImageData = null;
		try {
			apodImageData = JSONParser.parseJSON(responseJsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(apodImageData != null) {
			model.addAttribute("copyright", apodImageData.getCopyright());
			model.addAttribute("date", apodImageData.getDate());
			model.addAttribute("explanation", apodImageData.getExplanation());
			model.addAttribute("hdurl", apodImageData.getHdurl());
			model.addAttribute("title", apodImageData.getTitle());
		}
		
		return "apod";
    }
	
	@GetMapping("/nasa/api/apod/random")
    public String randomApod(String name, Model model)
    {
		String url = "https://api.nasa.gov/planetary/apod?count=1&api_key=GbmHwXYBm5sr50aITrpScOtQW0kVbmF1UmUPXlRv";
		RestTemplate rtemplate = new RestTemplate();
		String responseJsonString = rtemplate.getForObject(url, String.class);
		apodImage apodRandomImageData = null;
		try {
			List<apodImage> apodImageDataList = JSONParser.parseArrayJSON(responseJsonString);
			apodRandomImageData = apodImageDataList.get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(apodRandomImageData != null) {
			model.addAttribute("copyright", apodRandomImageData.getCopyright());
			model.addAttribute("date", apodRandomImageData.getDate());
			model.addAttribute("explanation", apodRandomImageData.getExplanation());
			model.addAttribute("hdurl", apodRandomImageData.getHdurl());
			model.addAttribute("title", apodRandomImageData.getTitle());
		}
		
		return "randomapod";
    }
	
	@GetMapping("/nasa/api/apod/range")
    public String apodDateRangeForm(Model model)
    {
		model.addAttribute("apoddaterangeinput", new DateRange());
		return "apoddaterangeinput";
    }
	
	@PostMapping("/nasa/api/apod/range")
    public String apodDateRange(@ModelAttribute DateRange dateRange, Model model)
    {
		
		String url = "https://api.nasa.gov/planetary/apod?start_date="+dateRange.getFromDate()+"&end_date="+dateRange.getToDate()+"&api_key=GbmHwXYBm5sr50aITrpScOtQW0kVbmF1UmUPXlRv";
		RestTemplate rtemplate = new RestTemplate();
		String responseJsonString = rtemplate.getForObject(url, String.class);
		List<apodImage> apodImageDataList = null;
		try {
			apodImageDataList = JSONParser.parseArrayJSON(responseJsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(apodImageDataList != null) {
			 model.addAttribute("apodImageDataList", apodImageDataList);
		}
		
		return "apoddaterange";
    }
	
	@GetMapping("/nasa/mars/photos")
    public String marsPhoto(Model model)
	{
		model.addAttribute("marsphotoinputdata", new MarsPhotoInputData());
		return "marsphotoinputdata";
    }
	
	@PostMapping("/nasa/mars/photos")
   public String marsPhoto(@ModelAttribute MarsPhotoInputData marsPhotoInputData, Model model)
   {
		
		String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/"+marsPhotoInputData.getRoverName()+"/photos?camera="+marsPhotoInputData.getCamera()+"&earth_date="+marsPhotoInputData.getEarth_date()+"&api_key=GbmHwXYBm5sr50aITrpScOtQW0kVbmF1UmUPXlRv";
		RestTemplate rtemplate = new RestTemplate();
		String responseJsonString = rtemplate.getForObject(url, String.class);
		List<marsRoverImage> marsRoverImageList = null;
		List<MarsPhoto> marsPhotosList = null;
		try {
			marsRoverImageList = JSONParser.parseMarsJSON(responseJsonString);
			marsRoverImage marsRoverImage = marsRoverImageList.get(0);
			marsPhotosList = marsRoverImage.getPhotos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(marsRoverImageList != null) {
			 model.addAttribute("marsRoverImageList", marsPhotosList);
		}
		
		return "marsrover";
    }
	
}
