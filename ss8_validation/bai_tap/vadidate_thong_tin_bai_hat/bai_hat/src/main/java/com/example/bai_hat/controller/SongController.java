package com.example.bai_hat.controller;

import com.example.bai_hat.dto.SongDto;
import com.example.bai_hat.model.Song;
import com.example.bai_hat.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showAllSong(@PageableDefault(size = 4) Pageable pageable, Model model) {
        model.addAttribute("songs", songService.getAll(pageable));
        return "view";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("create")
    public String addNewSong(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.addNewSong(song);
        redirectAttributes.addFlashAttribute("message", "Add new success fully!!!!");
        return "redirect:/song";
    }

    @GetMapping("update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (songService.getById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Song is not exist!!!!");
            return "redirect:/song";
        }
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(songService.getById(id), songDto);
        model.addAttribute("songDto", songDto);
        return "edit";
    }

    @PostMapping("update")
    public String updateSong(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = songService.getById(songDto.getId());
        BeanUtils.copyProperties(songDto, song);
        songService.updateSong(song);
        redirectAttributes.addFlashAttribute("message", "Update success fully!!!!");
        return "redirect:/song";
    }

    @PostMapping("delete")
    public String deleteSong(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        if (songService.getById(id) == null) {
            redirectAttributes.addAttribute("message", "Song is not exist!!!!");
        } else {
            songService.deleteSong(id);
            redirectAttributes.addFlashAttribute("message", "Delete success fully!!!!");
        }
        return "redirect:/song";
    }
}
