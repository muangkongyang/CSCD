package cscd211Interfaces;

import java.io.*;
import java.util.*;

public interface Taxable
{
   public static final double BASE_TAX_RATE = 0.068;
   public abstract double calculateTaxes();
}