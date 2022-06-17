package samesya.kotlin.restful.repository

import org.springframework.data.jpa.repository.JpaRepository
import samesya.kotlin.restful.entity.ApiKey

interface ApiKeyRepository : JpaRepository<ApiKey, String> {}
