package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:upload_file.properties")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public ModelAndView listMusic() {
        List<Music> musicList = musicService.findAll();
        ModelAndView mv = new ModelAndView("/list");
        mv.addObject("list", musicList);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView mv = new ModelAndView("/create");
        mv.addObject("music", new MusicForm());
        return mv;
    }

    @PostMapping("/create")
    public String createMusic(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music();
        music.setSongFile(fileName);
        music.setId(musicForm.getId());
        music.setName(musicForm.getName());
        music.setArtist(music.getArtist());
        musicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Music music = musicService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("editForm",music);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("editForm") MusicForm musicForm){
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music1 = new Music();
        music1.setSongFile(fileName);
        music1.setId(musicForm.getId());
        music1.setName(musicForm.getName());
        music1.setArtist(musicForm.getArtist());

        musicService.save(music1);
        System.out.println(music1);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        Music music = musicService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("deleteForm",music);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("deleteForm") Music music){
        musicService.remove(music.getId());
        return "redirect:/musics";
    }


}
