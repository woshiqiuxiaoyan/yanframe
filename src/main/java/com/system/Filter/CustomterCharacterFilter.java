package com.system.Filter;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;

/**
 * Servlet Filter that allows one to specify a character encoding for requests.
 * This is useful because current browsers typically do not set a character
 * encoding even if specified in the HTML page or form.
 *
 * <p>This filter can either apply its encoding if the request does not already
 * specify an encoding, or enforce this filter's encoding in any case
 * ("forceEncoding"="true"). In the latter case, the encoding will also be
 * applied as default response encoding (although this will usually be overridden
 * by a full content type set in the view).
 *
 * @author Juergen Hoeller
 * @since 15.03.2004
 * @see #setEncoding
 * @see #setForceEncoding
 * @see javax.servlet.http.HttpServletRequest#setCharacterEncoding
 * @see javax.servlet.http.HttpServletResponse#setCharacterEncoding
 */
@NoArgsConstructor
public class CustomterCharacterFilter extends OncePerRequestFilter {

    private String encoding;

    private boolean forceRequestEncoding = false;

    private boolean forceResponseEncoding = false;




    /**
     * Create a {@code CharacterEncodingFilter} for the given encoding.
     * @param encoding the encoding to apply
     * @since 4.2.3
     * @see #setEncoding
     */
    public CustomterCharacterFilter(String encoding) {
        this(encoding, false);
    }

    /**
     * Create a {@code CharacterEncodingFilter} for the given encoding.
     * @param encoding the encoding to apply
     * @param forceEncoding whether the specified encoding is supposed to
     * override existing request and response encodings
     * @since 4.2.3
     * @see #setEncoding
     * @see #setForceEncoding
     */
    public CustomterCharacterFilter(String encoding, boolean forceEncoding) {
        this(encoding, forceEncoding, forceEncoding);
    }

    /**
     * Create a {@code CharacterEncodingFilter} for the given encoding.
     * @param encoding the encoding to apply
     * @param forceRequestEncoding whether the specified encoding is supposed to
     * override existing request encodings
     * @param forceResponseEncoding whether the specified encoding is supposed to
     * override existing response encodings
     * @since 4.3
     * @see #setEncoding
     * @see #setForceRequestEncoding(boolean)
     * @see #setForceResponseEncoding(boolean)
     */
    public CustomterCharacterFilter(String encoding, boolean forceRequestEncoding, boolean forceResponseEncoding) {
        Assert.hasLength(encoding, "Encoding must not be empty");
        this.encoding = encoding;
        this.forceRequestEncoding = forceRequestEncoding;
        this.forceResponseEncoding = forceResponseEncoding;
    }


    /**
     * Set the encoding to use for requests. This encoding will be passed into a
     * {@link javax.servlet.http.HttpServletRequest#setCharacterEncoding} call.
     * <p>Whether this encoding will override existing request encodings
     * (and whether it will be applied as default response encoding as well)
     * depends on the {@link #setForceEncoding "forceEncoding"} flag.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Return the configured encoding for requests and/or responses
     * @since 4.3
     */
    public String getEncoding() {
        return this.encoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter
     * is supposed to override existing request and response encodings.
     * <p>Default is "false", i.e. do not modify the encoding if
     * {@link javax.servlet.http.HttpServletRequest#getCharacterEncoding()}
     * returns a non-null value. Switch this to "true" to enforce the specified
     * encoding in any case, applying it as default response encoding as well.
     * <p>This is the equivalent to setting both {@link #setForceRequestEncoding(boolean)}
     * and {@link #setForceResponseEncoding(boolean)}.
     * @see #setForceRequestEncoding(boolean)
     * @see #setForceResponseEncoding(boolean)
     */
    public void setForceEncoding(boolean forceEncoding) {
        this.forceRequestEncoding = forceEncoding;
        this.forceResponseEncoding = forceEncoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter
     * is supposed to override existing request encodings.
     * <p>Default is "false", i.e. do not modify the encoding if
     * {@link javax.servlet.http.HttpServletRequest#getCharacterEncoding()}
     * returns a non-null value. Switch this to "true" to enforce the specified
     * encoding in any case.
     * @since 4.3
     */
    public void setForceRequestEncoding(boolean forceRequestEncoding) {
        this.forceRequestEncoding = forceRequestEncoding;
    }

    /**
     * Return whether the encoding should be forced on requests
     * @since 4.3
     */
    public boolean isForceRequestEncoding() {
        return this.forceRequestEncoding;
    }

    /**
     * Set whether the configured {@link #setEncoding encoding} of this filter
     * is supposed to override existing response encodings.
     * <p>Default is "false", i.e. do not modify the encoding.
     * Switch this to "true" to enforce the specified encoding
     * for responses in any case.
     * @since 4.3
     */
    public void setForceResponseEncoding(boolean forceResponseEncoding) {
        this.forceResponseEncoding = forceResponseEncoding;
    }

    /**
     * Return whether the encoding should be forced on responses.
     * @since 4.3
     */
    public boolean isForceResponseEncoding() {
        return this.forceResponseEncoding;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String encoding = getEncoding();

        LoggerFactory.getLogger("CustomSystemLog").info("编码过滤request："+encoding);

        if (encoding != null) {
            if (isForceRequestEncoding() || request.getCharacterEncoding() == null) {
                request.setCharacterEncoding(encoding);

            }
            if (isForceResponseEncoding()) {
                response.setCharacterEncoding(encoding);
            }
        }
        filterChain.doFilter(request, response);
    }

}
