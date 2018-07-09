package bj.rawsteel.service

import bj.rawsteel.domain.QTemplate
import bj.rawsteel.domain.Template
import bj.rawsteel.repository.TemplateRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 18-7-8 下午4:16
 */
@Service
class TemplateService {

    @Resource
    private lateinit var templateRepository: TemplateRepository;

    fun findAll(pageable: Pageable): Page<Template> {
        val predicate = QTemplate.template.isNotNull
        return templateRepository.findAll(predicate, pageable)
    }

    fun findById(id: Long): Optional<Template> {
        return templateRepository.findById(id)
    }

    fun findByIdOrThrow(id: Long): Template {
        return findById(id).orElseThrow { RuntimeException("Template(id=$id) not exist") }
    }

    fun create(): Template {
        val template = Template().apply {
            createdAt = Date()
            updatedAt = createdAt
        }
        templateRepository.save(template)
        return template
    }

    fun update(id: Long): Template {
        val template = findByIdOrThrow(id).apply {
            updatedAt = Date()
        }
        templateRepository.save(template)
        return template
    }

    fun destroy(id: Long) {
        findByIdOrThrow(id)
        templateRepository.deleteById(id)
    }
}