import { cva } from 'class-variance-authority';
import Image from 'next/image';
import { useRef } from 'react';
import css from './projectCard.module.css';
import { cn } from '@/lib/utils';

const projectCardStyle = cva(
  'flex flex-col items-stretch rounded-2xl bg-[#fff0] p-4 transition-colors duration-700 ease-in-out cursor-pointer max-w-[400px] size-full h-[555px]',
  {
    variants: {
      color: {
        red: 'bg-gradient-red-transparent',
        green: 'bg-gradient-green-transparent',
        blue: 'bg-gradient-blue-transparent',
        violet: 'bg-gradient-violet-transparent',
      },
    },
    defaultVariants: {
      color: 'red',
    },
  }
);

export const ProjectCard = ({ h1, h2, desc, items, color = '', id, name = '', form }) => {
  const input = useRef();
  return (
    <label
      onClick={() => {
        if (input.current) {
          input.current.click();
          form?.requestSubmit();
        }
      }}
      htmlFor={id}
      className={cn(projectCardStyle({ color }), css.cardContainer)}>
      <input ref={input} className="hidden" type="radio" name={name} id={id} value={id} />
      <div className="flex size-full h-[555px] max-w-[400px] flex-col justify-between">
        <div className="flex flex-col items-center justify-center">
          <h3 className="mt-5 text-3xl font-medium leading-[120%] text-white">{h1}</h3>
          <p className="self-start font-light">{desc}</p>
          <h4 className="mb-2 mt-8 w-full text-left text-xl font-medium">{h2}</h4>
          <div className="flex flex-wrap">
            {items.map((item, i) => (
              <div
                key={item.text}
                className="m-1 flex flex-row items-center justify-between gap-4 rounded-md bg-[#ffffff0d] px-4 py-2 leading-5 text-[#acacb5]">
                <div
                  className={cn(
                    'flex size-7 flex-col items-center justify-center',
                    css.cardIconContainer
                  )}>
                  <Image
                    src={item.icon}
                    alt={item.text}
                    width={24}
                    height={24}
                    className={cn(
                      'aspect-square min-h-6 w-full min-w-6 max-w-none',
                      item.style || ''
                    )}
                  />
                </div>
                <div className="text-base font-medium leading-7">{item.text}</div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </label>
  );
};
