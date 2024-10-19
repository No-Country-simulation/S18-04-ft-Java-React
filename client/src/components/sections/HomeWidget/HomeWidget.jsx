import people from '/public/images/people.png';
import cv from '/public/images/cv.png';
import calendar from '/public/images/calendar.png';
import { SectionItem } from '@/components/SectionItem/SectionItem';

export const HomeWidget = () => (
  <section className="mx-auto mt-8 flex w-full max-w-[90%] justify-between gap-x-3 text-xs leading-[14px] text-white">
    <SectionItem iconSrc={people} label="Comunidad" />
    <SectionItem iconSrc={calendar} label="Calendario" />
    <SectionItem iconSrc={cv} label="Mi CV" />
  </section>
);
