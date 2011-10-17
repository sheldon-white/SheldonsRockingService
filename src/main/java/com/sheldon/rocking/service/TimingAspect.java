package com.sheldon.rocking.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class TimingAspect {

    private static final Log LOG = LogFactory.getLog(TimingAspect.class);

    @Around(value = "@annotation(com.sheldon.rocking.service.Timed) && @annotation(timed)", argNames = "timed")
    static Object timeMethod(final ProceedingJoinPoint pjp, final Timed timed) throws Throwable {
        return time(pjp, timed);
    }

    @Around("within(@com.sheldon.rocking.service.Timed *) && @target(timed)")
    static Object timeClass(final ProceedingJoinPoint pjp, final Timed timed) throws Throwable {
        return time(pjp, timed);
    }

    private static Object time(final ProceedingJoinPoint pjp, final Timed timed) throws Throwable {
        final Signature signature = pjp.getSignature();
        final String longString = "[" + signature.toLongString() + "]";

        LOG.info(">>>> started " + longString);

        final long startTimeMs = System.currentTimeMillis();

        try {
            return pjp.proceed();
        } finally {
            final long timeTakenMs = System.currentTimeMillis() - startTimeMs;
            LOG.info("<<<< completed " + longString + " (took " + timeTakenMs + "ms)\n");
        }
    }
}
