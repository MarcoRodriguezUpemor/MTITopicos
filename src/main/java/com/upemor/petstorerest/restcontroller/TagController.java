package com.upemor.petstorerest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upemor.petstorerest.exception.TagErrorException;
import com.upemor.petstorerest.model.Tag;
import com.upemor.petstorerest.service.TagService;

@RestController
@RequestMapping("/api/tag")
@CrossOrigin("*")
public class TagController {

	@Autowired
	private TagService tagService;
	
	@GetMapping("/")
	public ResponseEntity<List<Tag>> listAllTags(){
		List<Tag> tags = tagService.listAllTags();
		return new ResponseEntity<List<Tag>>(tags,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tag> findById(@PathVariable("id") final int id){
		Tag tag = tagService.findById(id);
		if (tag == null) {
			return new ResponseEntity<Tag>(
					new TagErrorException("Tag with id "
					+ id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tag>(tag, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tag> createTag(@RequestBody final Tag tag) {
		tagService.createTag(tag);		
		return new ResponseEntity<Tag>(tag, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tag> updateTag(@PathVariable("id") final int id, @RequestBody Tag tag) {
		Tag currentTag = tagService.findById(id);
		if (currentTag == null) {
			return new ResponseEntity<Tag>(
					new TagErrorException("Unable to upate. Tag with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		Tag updatedTag = tagService.updateTag(id, tag);
		return new ResponseEntity<Tag>(updatedTag, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Tag> deleteTag(@PathVariable("id") final int id) {
		Tag currentTag = tagService.findById(id);
		if (currentTag == null) {
			return new ResponseEntity<Tag>(
					new TagErrorException("Unable to delete Tag with id "
					+ id + " not found."), HttpStatus.NOT_FOUND);
		}
		tagService.deleteTag(id);
		return new ResponseEntity<Tag>(HttpStatus.NO_CONTENT);
	}
}
