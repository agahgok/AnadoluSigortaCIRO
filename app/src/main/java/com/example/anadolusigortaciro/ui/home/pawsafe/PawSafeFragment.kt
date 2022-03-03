package com.example.anadolusigortaciro.ui.home.pawsafe

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.anadolusigortaciro.MainActivity
import com.example.anadolusigortaciro.databinding.FragmentPawSafeBinding

class PawSafeFragment : Fragment(){
    private lateinit var binding: FragmentPawSafeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPawSafeBinding.inflate(inflater, container, false)
        webViewSetup()
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup(){
        binding.webViewPawSafe.webViewClient = WebViewClient()

        binding.webViewPawSafe.apply {
            loadUrl("https://www.anadolusigorta.com.tr/tr/patim-guvende-sigortasi")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true

            binding.webViewPawSafe.webViewClient = object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    binding.progressBar.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }
        }
    }
}